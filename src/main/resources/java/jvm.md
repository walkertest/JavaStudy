# 字节码
idea中的view菜单下，有一个show bytecode，可以直接查看java类的字节码工具，可以不用javac/javap编译和反汇编来查看，比较方便.


# 类加载器
## 类加载器的流程
从类被加载到虚拟机内存中开始，到释放内存总共有7个步骤：加载，验证，准备，解析，初始化，使用，卸载。其中验证，准备，解析三个部分统称为连接

## 类加载器的加载顺序

加载一个Class类的顺序也是有优先级的，类加载器从最底层开始往上的顺序是这样的
```aidl
BootStrap ClassLoader：rt.jar
Extension ClassLoader: 加载扩展的jar包
App ClassLoader：指定的classpath下面的jar包
Custom ClassLoader：自定义的类加载器
```

## 双亲委派机制
### 是什么
当一个类收到了加载请求时，它是不会先自己去尝试加载的，而是委派给父类去完成，比如我现在要new一个Person，这个Person是我们自定义的类，如果我们要加载它，就会先委派App ClassLoader，只有当父类加载器都反馈自己无法完成这个请求（也就是父类加载器都没有找到加载所需的Class）时，子类加载器才会自行尝试加载


## 好处、作用
* 防止重复加载；
* 安全，避免了我们的代码影响了JDK的代码
这样做的好处是，加载位于rt.jar包中的类时不管是哪个加载器加载，最终都会委托到BootStrap ClassLoader进行加载，这样保证了使用不同的类加载器得到的都是同一个结果。
其实这个也是一个隔离的作用，避免了我们的代码影响了JDK的代码，比如我现在要来一个


# 垃圾回收
## 判断是否为垃圾
### 引用计数法
* 给对象中添加一个引用计数器，每当有一个地方引用它，计数器就加 1；当引用失效，计数器就减 1；任何时候计数器为 0 的对象就是不可能再被使用的
* 这个方法实现简单，效率高，但是目前主流的虚拟机中并没有选择这个算法来管理内存，其最主要的原因是它很难解决对象之间相互循环引用的问题。
### 可达性分析
这个算法的基本思想就是通过一系列的称为 **“GC Roots”** 的对象作为起点，从这些节点开始向下搜索，节点所走过的路径称为引用链，当一个对象到 GC Roots 没有任何引用链相连的话，则证明此对象是不可用的。


## 垃圾回收算法
### 标记清除
* 首先是标记过程，标记好不需要回收的对象，然后将需要回收的对象清除掉。
* 问题：效率问题、空间问题（会造成垃圾碎片）
### 标记复制
* 分为两块内容，将不需要回收的内容，放入到另外一块； （复制过程）
* 然后清除掉整块内容，效率较高；
* 浪费空间； 适合大部分都要回收的内容；
### 标记整理
* 主要用来解决标记清除的空间问题，不会有碎片问题
* 将不需要清除的对象，移动到空间的一端；
* 然后批量清理即可；

### 分代收集
* 年轻代使用标记复制；
* 老年代使用标记整理；

### 具体的垃圾回收器
* Serial 收集器
单线程垃圾回收器，stop the world

* ParNew 收集器
Serial 收集器的多线程版本

* Parallel Scavenge 收集器
这是 JDK1.8 默认收集器

* CMS 收集器
CMS（Concurrent Mark Sweep）收集器是一种以获取最短回收停顿时间为目标的收集器。它非常符合在注重用户体验的应用上使用。

CMS（Concurrent Mark Sweep）收集器是 HotSpot 虚拟机第一款真正意义上的并发收集器，它第一次实现了让垃圾收集线程与用户线程（基本上）同时工作。

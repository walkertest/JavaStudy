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
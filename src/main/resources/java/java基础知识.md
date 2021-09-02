## java 语言特点
* 平台无关；
* 生态体系好；
* 可靠性；
* 编译与解释并存的语言。 编译 由编译器将源码一次性翻译成机器码，解释是 由解释器在运行时将源码翻译成机器码。  一定程度上解决了解释型语言效率低的问题，同时又保留了解释型可移植的特点；


## jdk VS jre  VS jvm 
* 整体上是jdk > jre > jvm
* jdk，java的sdk，包含jre，还额外拥有编译器（javac）和工具（java doc和jdb等）；
* jre，java的运行时环境，包括jvm、java类库等；
* jvm是运行java字节码的虚拟机； jvm的类加载器首先加载字节码，然后由解释器解释执行；有些热点代码，可以将对应的字节码编译生成的字节码保存下来（JIT编译器），通过复用提升效率。
参考：https://cloud.tencent.com/developer/article/1757182

## java泛型
* 伪泛型，在编译期间，会把泛型信息擦除掉.
* 一般有三种使用方式：泛型类、泛型接口、泛型方法；
* 常用的通配符为： T，E，K，V，？
```aidl
？ 表示不确定的 java 类型
T (type) 表示具体的一个 java 类型
K V (key value) 分别代表 java 键值中的 Key Value
E (element) 代表 Element
```


## equals和==的比较
* equeals只适用于引用变量，如果变量类型没有实现equals方法，那么和==等同； 如果实现了，就按照重写的方法去比较，一般是比较变量的内容是否一致；
* ==，基本类型的话，比较值是否一直； 引用类型的话，表示对象的内存地址是否一致，也就是对象是否是同一个对象.


## hashcode和equals的关系
* hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个 int 整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。hashCode()定义在 JDK 的 Object 类中，这就意味着 Java 中的任何类都包含有 hashCode() 函数。另外需要注意的是： Object 的 hashcode 方法是本地方法，也就是用 c 语言或 c++ 实现的，该方法通常用来将对象的 内存地址 转换为整数之后返回
* 散列表存储的是键值对(key-value)，它的特点是：能根据“键”快速的检索出对应的“值”。这其中就利用到了散列码！（可以快速找到所需要的对象）


## 自动拆箱与装箱
```aidl
Integer i = 10;  //装箱
int n = i;   //拆箱
keyPoint:
字节码看过程：
Integer.valueOf();
i.intValue();

拆箱的过程中，经常会遇到NPE的问题. 引用类型可能是null的.
```


## 值传递
java只有值传递. 引用参数，传递的是引用对象的内存地址；


## java异常
todo


## 引用
参考：https://blog.csdn.net/hohoo1990/article/details/106356145
### 强引用
Object a = new Object(); 即为强引用.

### 软引用
可以是在排除过期数据的情况下。JDK中有个类叫ResourceBundle，内部会使用ConcurrentMap缓存ResourceBundle对象，这里就是使用的软引用机制。

### 弱引用
个人理解，是在较为复杂的数据结构中，为了避免内存泄露而使用的一种引用方式；

### 虚引用
虚引用有一个很重要的用途就是用来做堆外内存的释放，DirectByteBuffer就是通过虚引用来实现堆外内存的释放；




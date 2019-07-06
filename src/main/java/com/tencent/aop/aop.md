参考:https://blog.csdn.net/javazejian/article/details/56267036#%E5%9F%BA%E4%BA%8Easpect-spring-aop-%E5%BC%80%E5%8F%91
* aop是一种编程范式,面向切面编程.比如鉴权/打印日志等等场景.
* 什么是aop:https://www.zhihu.com/question/24863332
* spring aop基于动态代理:jdk proxy和Cglib. 在使用时机上进行动态调整,当有接口时,使用jdk proxy,否则使用 cglib.
* jdk proxy:被代理类必须实现接口.
* 动态代理的底层是通过反射来实现的,通过反射拿到被代理类和它的实现类,然后生成代理类,去执行我们的切面逻辑.
* Filter和Inteceptor是责任链模式,spring aop是代理模式.


# aop中的关键概念
* aspect:切面,具体的需要切入的逻辑;
* jointpoint:事件类型:方法被调用,抛出异常.
* Pointcut:哪个函数需要切入;
* advice:切入类型,有几种:before/after/around/after throwing advice.
package com.tencent.aop.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * Created by walker on 2019/7/6.
 */
public class Main {
    public static void main(String[] args) {
        SayImpl sayImpl = new SayImpl();
        SayAopHandler sayAopHandler = new SayAopHandler(sayImpl);

        SayInterface sayInterface =
                (SayInterface) Proxy.newProxyInstance(SayImpl.class.getClassLoader(),
                        new Class[]{SayInterface.class}, sayAopHandler);

        sayInterface.say();
    }
}

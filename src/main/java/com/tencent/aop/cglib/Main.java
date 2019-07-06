package com.tencent.aop.cglib;

/**
 * Created by walker on 2019/7/6.
 */
public class Main {
    public static void main(String[] args) {
        SayCglibProxy sayCglibProxy = new SayCglibProxy();

        Say say = (Say) sayCglibProxy.getProxy(Say.class);

        say.say();

    }
}

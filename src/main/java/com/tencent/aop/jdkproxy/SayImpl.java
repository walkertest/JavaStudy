package com.tencent.aop.jdkproxy;

/**
 * Created by walker on 2019/7/6.
 */
public class SayImpl implements SayInterface{


    @Override
    public void say() {
        System.out.println("say impl.");
    }
}

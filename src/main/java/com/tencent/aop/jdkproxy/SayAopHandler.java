package com.tencent.aop.jdkproxy;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by walker on 2019/7/6.
 */
public class SayAopHandler implements InvocationHandler {

    private Object obj;
    SayAopHandler(Object obj){
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk aop exeute before.");
        Object result = method.invoke(obj, args);

        System.out.println("jdk aop exeute after.");

        return result;
    }
}

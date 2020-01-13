package com.tencent.javabase;

/**
 *
 * https://blog.csdn.net/boatalways/article/details/17121205
 * Created by walker on 2019/7/20.
 */
public class FloatTest {
    public static void main(String[] args) {
        testFloat();
    }

    private static void testFloat() {
        System.out.println(0.99999999f == 1);

        float a= 0.8f;
        float b= 0.1f;
        float c = a+b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


        System.out.println(0.4*0.2);

        System.out.println(40000000.0f == 40000000.5f); // float类型字面量
    }
}

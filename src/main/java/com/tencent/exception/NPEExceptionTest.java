package com.tencent.exception;

/**
 * @description: java对象类型转换为基本类型的时候，java会做自动拆箱操作.
 * javac NPEExceptionTest.java,编译成字节码
 * javap -v NPEExceptionTest.class,查看字节码内容，会发现有一步Long.longvalue()的操作.
 * @author: walker
 * @create: 2020-01-13 17:30
 **/

public class NPEExceptionTest {
	public static void main(String[] args) {
		testUnboxException();
	}

	private static void testUnboxException() {
		Long uid=null;
		if(uid < 0) {
			System.out.println("not valid uid");
		}
	}
}

package com.tencent.tool.antlr.calexpr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @description: add your desc
 * @author: walker
 * @create: 2022-04-22 11:48
 **/
public class CalExprTest {
	public static void main(String[] args) {
		String expr = "a=1 \n" +
				"b=2 \n" +
				"c=(a+b)/2 \n" +
				"c\n" +
				"d=a\n" +
				"f=d\n" +
				"f\n" +
				"11\n" +
				"f=a+b+c\n" +
				"f\n" +
				"CLEANMEM \n" +
				"a=4\n" +
				"a!+(2^2)+1\n";

		System.out.println(expr);

		CharStream stream= CharStreams.fromString(expr);
		CalExprLexer lexer=new CalExprLexer(stream);
		CalExprParser parser = new CalExprParser(new CommonTokenStream(lexer));

		ParseTree parseTree = parser.prog();
		String res = parseTree.toStringTree(parser);
		System.out.println(res);


		MyCalVistor<IType> parseTreeWalker = new MyCalVistor();
		IType value = parseTreeWalker.visit(parseTree);
		System.out.println(value.getValue());
	}

}

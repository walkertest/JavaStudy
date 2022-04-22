// Generated from F:/javatask/github/JavaStudy/src/main/resources/java/antlr\CalExpr.g4 by ANTLR 4.10.1
package com.tencent.tool.antlr.calexpr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalExprParser}.
 */
public interface CalExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(CalExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(CalExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(CalExprParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(CalExprParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CalExprParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CalExprParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cleanmem}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterCleanmem(CalExprParser.CleanmemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cleanmem}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitCleanmem(CalExprParser.CleanmemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(CalExprParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link CalExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(CalExprParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumber(CalExprParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumber(CalExprParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(CalExprParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(CalExprParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(CalExprParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(CalExprParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(CalExprParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(CalExprParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pow}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPow(CalExprParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pow}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPow(CalExprParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fac}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFac(CalExprParser.FacContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fac}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFac(CalExprParser.FacContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(CalExprParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link CalExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(CalExprParser.IdContext ctx);
}
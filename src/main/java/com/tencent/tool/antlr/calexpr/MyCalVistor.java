package com.tencent.tool.antlr.calexpr;

import org.apache.commons.math3.util.ArithmeticUtils;


public class MyCalVistor<T extends IType> extends CalExprBaseVisitor<T>{

    @Override
    public T visitCleanmem(CalExprParser.CleanmemContext ctx) {
        CalVarb.cleanmem();
        return super.visitCleanmem(ctx);
    }

    @Override
    public T visitPrintExpr(CalExprParser.PrintExprContext ctx) {
        IType iType = ctx.expr().accept(this);
        if(iType.isValue()){
            System.out.println(iType.getValue());
        }
        else  if(iType.isVarb()){
            System.out.println(ctx.getText().trim()+" = "+iType.getValue());
        }
        return (T)iType;
    }

    @Override
    public T visitAssign(CalExprParser.AssignContext ctx) {
        CalVarb calVarb = new CalVarb(ctx.ID().getText());
        IType iType = ctx.expr().accept(this);
        calVarb.setValue(iType.getValue());
        return (T)calVarb;
    }

    @Override
    public T visitFac(CalExprParser.FacContext ctx) {
        IType iType = ctx.expr().accept(this);
        Double l = ArithmeticUtils.factorialDouble(iType.getValue().intValue());
        return (T) new CalNumber(l.toString());
    }

    @Override
    public T visitPow(CalExprParser.PowContext ctx) {
        CalExprParser.ExprContext left = ctx.expr().get(0);
        CalExprParser.ExprContext right = ctx.expr().get(1);
        IType leftItype = left.accept(this);
        IType rightItype = right.accept(this);

        Integer l = ArithmeticUtils.pow(leftItype.getValue().intValue(),rightItype.getValue().intValue());
        return (T) new CalNumber(l.toString());
    }

    @Override
    public T visitParens(CalExprParser.ParensContext ctx) {
        IType iType = ctx.expr().accept(this);
        return (T)iType;
    }

    @Override
    public T visitMulDiv(CalExprParser.MulDivContext ctx) {
        CalExprParser.ExprContext left = ctx.expr().get(0);
        CalExprParser.ExprContext right = ctx.expr().get(1);
        IType leftItype = left.accept(this);
        IType rightItype = right.accept(this);
        Double temp = 0d;
        if(ctx.MUL()!=null){
            temp = leftItype.getValue()*rightItype.getValue();
        }
        if(ctx.DIV()!=null){
            temp = leftItype.getValue()/rightItype.getValue();
        }

        return (T)new CalNumber(temp.toString());
    }

    @Override
    public T visitAddSub(CalExprParser.AddSubContext ctx) {
        CalExprParser.ExprContext left = ctx.expr().get(0);
        CalExprParser.ExprContext right = ctx.expr().get(1);
        IType leftItype = left.accept(this);
        IType rightItype = right.accept(this);
        Double temp = 0d;
        if(ctx.ADD()!=null){
            temp = leftItype.getValue()+rightItype.getValue();
        }
        if(ctx.SUB()!=null){
            temp = leftItype.getValue()-rightItype.getValue();
        }
        return (T)new CalNumber(temp.toString());
    }

    @Override
    public T visitId(CalExprParser.IdContext ctx) {
        CalVarb calVarb = new CalVarb(ctx.ID().getText());
        return (T)calVarb;
    }

    @Override
    public T visitNumber(CalExprParser.NumberContext ctx) {
        CalNumber number = new CalNumber(ctx.getText());
        return (T) number;
    }
}
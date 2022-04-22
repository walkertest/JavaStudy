package com.tencent.tool.antlr.calexpr;

public class CalNumber implements IType{
    private Double _value;

    public CalNumber(String str){
        _value = Double.valueOf(str);
    }
    public void setValue(Double d){
        _value = d;
    }



    @Override
    public Double getValue() {
        return _value;
    }


    @Override
    public Boolean isValue() {
        return true;
    }

    @Override
    public Boolean isVarb() {
        return false;
    }

    @Override
    public String toString() {
        return "CalNumber{" +
                "_value=" + _value +
                '}';
    }
}
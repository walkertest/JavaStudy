package com.tencent.tool.antlr.calexpr;

public interface IType {
    /**
     * 获取当前对象的值
     * */
    Double getValue();

    /**
     * 设置当前值
     * */
    void setValue(Double d);


    /**
     * 判断是否为值类型
     * */
    Boolean isValue();


    /**
     * 是否是变量
     * */
    Boolean isVarb();
}
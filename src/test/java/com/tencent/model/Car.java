package com.tencent.model;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@Data
//@JSONType(typeName = "car")
public  class Car  extends Vehicle {
    private String car;

    @Override
    public String toString() {
        return "Car{" +
                "car='" + car + '\'' +
                "} " + super.toString();
    }
}
package com.tencent.model;

import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@Data
//@JSONType(typeName = "vehicle",seeAlso = { Car.class, Plane.class })
public class Vehicle {
    private String data;
}
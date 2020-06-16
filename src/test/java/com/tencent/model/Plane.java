package com.tencent.model;

import com.alibaba.fastjson.annotation.JSONType;
import com.tencent.json.JsonTest;
import lombok.Data;

@Data
//@JSONType(typeName = "plane")
public class Plane extends Vehicle {
    private String plane;

    @Override
    public String toString() {
        return "Plane{" +
                "plane='" + plane + '\'' +
                "} " + super.toString();
    }
}
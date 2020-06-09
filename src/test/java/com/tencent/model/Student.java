package com.tencent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Student {

    private transient long id;
    private String name;
    private String gender;
    private int age;

    @SerializedName(value="resultcode", alternate = {"resultCode"})
    private String resultcode;   //大小写测试.

    public Student() {
    }

    public Student(long id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

}

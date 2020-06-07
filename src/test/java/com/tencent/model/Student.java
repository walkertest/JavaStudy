package com.tencent.model;

import lombok.Data;

@Data
public class Student {

    private long id;
    private String name;
    private String gender;
    private int age;

    public Student(long id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

}

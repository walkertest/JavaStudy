package com.tencent.model;

import lombok.Data;

import java.util.List;

@Data
public class ClassRoom {
    private long id;
    private String className;
    private List<Student> students;


    public ClassRoom() {
    }

    public ClassRoom(long id, String className, List<Student> students) {
        this.id = id;
        this.className = className;
        this.students = students;
    }

}

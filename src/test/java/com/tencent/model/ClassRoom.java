package com.tencent.model;

import java.util.List;

public class ClassRoom {
    private long id;
    private String className;
    private List<Student> students;

    public ClassRoom(long id, String className, List<Student> students) {
        this.id = id;
        this.className = className;
        this.students = students;
    }

}

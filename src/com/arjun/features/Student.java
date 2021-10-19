package com.arjun.features;

public class Student implements Cloneable{
    String name = null;
    int id = 0;

    // default constructor
    Student() {
    }

    // parameterized constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

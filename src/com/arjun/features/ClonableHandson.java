package com.arjun.features;

public class ClonableHandson {
    public static void main(String[] args)  {
        Student student1=new Student("Arjun",2);

        try {
            Student student2= (Student) student1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}

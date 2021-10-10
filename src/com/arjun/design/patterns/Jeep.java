package com.arjun.design.patterns;

public class Jeep implements Vehicle{

    @Override
    public void printDetails() {
        System.out.println("This is a JEEP");
    }

    public void jeepSpecifics(){
        System.out.println("A great jeep");
    }
}

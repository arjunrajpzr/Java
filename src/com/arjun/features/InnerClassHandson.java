package com.arjun.features;


import com.arjun.business.OuterClass;

public class InnerClassHandson {
    public static void main(String[] args) {


        OuterClass outerObject = new OuterClass();

        OuterClass.InnerClass innerObject=outerObject.new InnerClass();

        System.out.println("outerClassVariable: "+outerObject.getOuterClassVariable());
        System.out.println("getVariable()- outerclass: "+outerObject.getVariable());
        System.out.println("innerClassVariable: "+innerObject.getInnerClassVariable());
        System.out.println("getVariable()- inner class: "+innerObject.getVariable());
        System.out.println("outerClassVariable: "+innerObject.getOuterClassVariable());

    }
}

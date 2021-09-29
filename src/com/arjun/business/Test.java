package com.arjun.business;

public class Test {

    private String string;

    public Test(){
        string="GeeksForGeeks";
    }

    public void printValue(){
        System.out.println("String is "+string);
    }

    public void printIncomingValue(int i){
        System.out.println("Incoming integer value is "+i);
    }

    private void privateMethod(){
        System.out.println("Private method invoked");
    }


}

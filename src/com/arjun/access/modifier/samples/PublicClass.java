package com.arjun.access.modifier.samples;

public class PublicClass {

    int a;
    private int b;
    public int c;
    protected int d;

    public int getA1() {
        return a;
    }

    private int getA2() {
        return a;
    }

    protected int getA3() {
        return a;
    }

    int getA4() {
        return a;
    }
}

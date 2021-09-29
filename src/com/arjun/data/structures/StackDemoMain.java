package com.arjun.data.structures;

public class StackDemoMain {


    public static <T> void print(T t) {
        System.out.println("Accept" + t);

    }

    public static void main(String[] args) {
        PeekStack stack = new PeekStack();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(4);


        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("peekMax: " + stack.peekMax());

        StackDemoMain.print(4);
        StackDemoMain.print(2.4);
        StackDemoMain.print("Hello");

        String string="Accenture";
        System.out.println("Substring- "+string.substring(2,5));

    }

}

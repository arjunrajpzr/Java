package com.arjun.others;

import java.util.Stack;

public class PeekStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> peekMaxStack = new Stack<>();

    public void push(int value) {
        synchronized (this) {
            mainStack.push(value);
            if (peekMaxStack.isEmpty()) {
                peekMaxStack.push(value);
            } else {
                if (value > peekMaxStack.peek()) {
                    peekMaxStack.push(value);
                } else {
                    peekMaxStack.push(peekMaxStack.peek());
                }
            }
            System.out.println("value=%s, thread=%s"+value+Thread.currentThread().getName());
        }
//        return "pushed value";
    }

    public synchronized int pop() {
        peekMaxStack.pop();
        return mainStack.pop();
    }

    public int peekMax() {
        return peekMaxStack.peek();
    }

    public int peek() {
        return mainStack.peek();
    }
}

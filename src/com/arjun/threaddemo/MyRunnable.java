package com.arjun.threaddemo;

public class MyRunnable implements Runnable {

    private int id;
    private Thread thread = new Thread(this);

    @Override
    public void run() {
        System.out.println("Hello from " + this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "id=" + id +
                ", thread=" + thread +
                '}';
    }
}

package com.arjun.threaddemo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UseMyRunnable {
    public static void main(String[] args) {
        List<MyRunnable> threads = Stream.iterate(0, x -> x + 1)
                .map(x -> new MyRunnable())
                .limit(10)
                .collect(Collectors.toList());

        threads.forEach(MyRunnable::start);
    }
}

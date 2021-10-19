package com.arjun.javacollections;

/**
 * These structures are very simple and gives you three main operations.
 *
 *     push(element): adds an element to the queue, or the stack
 *     pop(): removes an element from the stack, that is, the youngest element added
 *     poll(): removes an element from the queue, that is, the oldest element added
 *     peek(): allows you to see the element you will get with a pop() or a poll(), but without removing it from the queue of the stack.
 *
 *     Stacks and queues are also widely used in concurrent programming. These interfaces are further extended by more interfaces, adding methods useful in this field.
 *     These interfaces, BlockingQueue, BlockingDeque and TransferQueue, are at the intersection of the Collections Framework and concurrent programming in Java.
 */
public class StackAndQueueHandson {

    public static void main(String[] args) {
        // The Queue interface models a queue;

        // The Deque interface models a double ended queue (thus the name).
        // You can push, pop, poll and peek elements on both the tail and the head of a Deque,
        // making it both a queue and a stack.


        //Both the Queue and the Deque interfaces add behavior to these three fundamental operations to deal with two corner cases.
        //
        //    1. A queue may be full and not able to accept more elements
        //    2. A queue may be empty and cannot return an element with a pop, poll, nor the peek operation.


    }
}

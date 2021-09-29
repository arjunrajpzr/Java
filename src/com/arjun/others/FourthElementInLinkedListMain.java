package com.arjun.others;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the fourth element from the end in a linked list in one pass?
 */

public class FourthElementInLinkedListMain {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);


        Iterator itrFirst = list.iterator();
        Iterator itrSecond = list.iterator();

        int count = 0;
        int fourthLastNum = 0;
        while (itrFirst.hasNext()) {
            if (count++ >= 3) {
                fourthLastNum = (int) itrSecond.next();
            }
            itrFirst.next();
        }
        System.out.println(fourthLastNum);
    }
}

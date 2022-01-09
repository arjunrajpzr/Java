package com.arjun.puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SubListReversalBasedOnAnotherList {
    public static void main(String[] args) {
        System.out.println("Hello");

        List<Integer> arr = Arrays.asList(1, 5, 3, 4, 5);

        //expected output:      4, 3, 1, 5, 5
        //input:                1, 2, 3, 4, 5
        //expected output:      4, 3, 1, 5, 2
        List<List<Integer>> patterns = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 3),
                Arrays.asList(3, 4)
        );

        int arrSize = arr.size();

        Integer[] inputArr = arr.toArray(new Integer[arrSize]);
        Integer[] outputArr = new Integer[arrSize];


        for (List<Integer> pattern : patterns) {
            int lowerLimit = pattern.get(0);
            int upperLimit = pattern.get(1);
            int position = lowerLimit;

            //0,1,2,3
            //3,2,1,0
            for (int i = upperLimit; i >= lowerLimit; i--) {
                outputArr[position++] = inputArr[i];
            }

            for (int i = lowerLimit; i <= upperLimit; i++) {
                inputArr[i] = outputArr[i];
            }
        }
        System.out.println("Result:" + Arrays.deepToString(outputArr));

    }
}
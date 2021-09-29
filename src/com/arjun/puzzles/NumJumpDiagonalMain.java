package com.arjun.puzzles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Jump 1 step forth and back diagonally , then 2 steps forth and back diagonally and stop until you reach the end.
 * <p>
 * 1    *    *    *    *        1   0,0      0   0
 * *    2    *    *    *        2   1,1      1   0+1
 * 3    *    *    *    *        1   2,0      2   1-1
 * *    4    *    *    *        2   3,1      3   0+1
 * *    *    5    *    *        3   4,2      4   1+1
 * *    6    *    *    *        2   5,1      5   2-1
 * 7    *    *    *    *        1   6,0      6   1-1
 * *    8    *    *    *        2   7,1      7   0+1
 * *    *    9    *    *        3   8,2      8   1+1
 * *    *    *    10   *        4   9,3      9   2+1
 * <p>
 * <p>
 * <p>
 * <p>
 * Output: 1 2 3 4 5 6 7 8 9 10
 */
public class NumJumpDiagonalMain {

    public static void main(String[] args) throws IOException {


        int size, i, j, incValue, prevColValue, count;
        int[] pattern;
        int[] output;
        boolean isIncValueRepeated = true;

        System.out.println("Please enter size of the pattern");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bf.readLine());

        pattern = new int[size];
        output = new int[size];
        int input[][] = new int[size][size / 2];
        String[] line;
        System.out.println("Please enter the pattern");
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        for (i = 0; i < input.length; i++) {
            line = sc.nextLine().trim().split(" ");
            for (j = 0; j < line.length; j++) {
                input[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println("Input Array: " + Arrays.deepToString(input));


/*
        int[][] input = {
                {1, 0, 0, 0, 0},
                {0, 2, 0, 0, 0},
                {3, 0, 0, 0, 0},
                {0, 4, 0, 0, 0},
                {0, 0, 5, 0, 0},
                {0, 6, 0, 0, 0},
                {7, 0, 0, 0, 0},
                {0, 8, 0, 0, 0},
                {0, 0, 9, 0, 0},
                {0, 0, 0, 10, 0}
        };

*/

        // * 1    *    *    *    *   0   0         0,0
        // * *    2    *    *    *   1   0+1       1,1
        // * 3    *    *    *    *   2   1-1       2,0
        // * *    4    *    *    *   3   0+1       3,1
        // * *    *    5    *    *   4   1+1       4,2
        // * *    6    *    *    *   5   2-1       5,1
        // * 7    *    *    *    *   6   1-1       6,0
        // * *    8    *    *    *   7   0+1       7,1
        // * *    *    9    *    *   8   1+1       8,2
        // * *    *    *    10   *   9   2+1       9,3
        //

        incValue = 1;
        count = incValue;
        pattern[0] = 0;
        pattern[1] = 1;
        prevColValue = pattern[1];
        for (i = 2; i < size; i++) {

            if (count-- >= 1) {
                if (!isIncValueRepeated) {
                    pattern[i] = 1;
                } else {
                    pattern[i] = -1;
                }
            } else {
                if (!isIncValueRepeated) {

                    isIncValueRepeated = true;
                    pattern[i] = -1;
                } else {
                    ++incValue;
                    isIncValueRepeated = false;
                    pattern[i] = 1;
                }
                count = incValue - 1;
            }
            pattern[i] += prevColValue;
            prevColValue = pattern[i];
        }


        output[0] = input[0][0];
        output[1] = input[1][1];
        for (i = 2; i < size; i++) {
            output[i] = input[i][pattern[i]];

        }
        System.out.println("Output: "+Arrays.toString(output));

    }

}

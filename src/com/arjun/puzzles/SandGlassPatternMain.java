package com.arjun.puzzles;


import java.util.Arrays;

//@formatter:off
/**
 *                 * * * * *            0                          0,0     0,1     0,2     0,3     0,4
 *                  * * * *             1                          1,0     1,1     1,2     1,3
 *                   * * *              2                          2,0     2,1     2,2
 *                    * *               3                          3,0     3,1
 *                     *                4                          4,0
 *                     *                5   0           1   4      5,0
 *                    * *               6   0,1         2   4      6,0     6,1
 *                   * * *              7   0,1,2       3   4      7,0     7,1     7,2
 *                  * * * *             8   0,1,2,3     4   4      8,0     8,1     8,2     8,3
 *                 * * * * *            9   0,1,2,3,4   5   4      9,0     9,1     9,2     9,3     9,4
 *
 */
//@formatter:on

public class SandGlassPatternMain {
    public static void main(String[] args) {
        char[][] sandGlassPattern = new char[10][5];
        int i, j;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < (10 / 2) - i; j++) {
                sandGlassPattern[i][j] = '*';
            }
            if (i >= 5) {
                for (j = 0; j < i - 4; j++) {
                    sandGlassPattern[i][j] = '*';
                }
            }
        }

        for (i = 0; i < 10; i++) {
            for (j = 0; j < 5; j++) {
                System.out.print(sandGlassPattern[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

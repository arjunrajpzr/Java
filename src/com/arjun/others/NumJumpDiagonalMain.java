package com.arjun.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Jump 1 step forth and back diagonally , then 2 steps forth and back diagonally and stop until you reach the end.
 * <p>
 * 1    *    *    *    *        1   0,0
 * *    2    *    *    *        2   1,1
 * 3    *    *    *    *        1   2,0
 * *    4    *    *    *        2   3,1
 * *    *    5    *    *        3   4,2
 * *    6    *    *    *        2   5,1
 * 7    *    *    *    *        1   6,0
 * *    8    *    *    *        2   7,1
 * *    *    9    *    *        3   8,2
 * *    *    *    10   *        4   9,3
 * <p>
 * <p>
 * <p>
 * <p>
 * Output: 1 2 3 4 5 6 7 8 9 10
 */
public class NumJumpDiagonalMain {

    public static void main(String[] args) throws IOException {




       BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        bf.readLine();
        int size = 10;

        int[] finalOutput = new int[size];

        int[] pattern = new int[size];

        int[][] input = new int[10][5];
        input[0][0] = 1;
        input[0][1] = 1;
        input[0][2] = 1;
        input[0][3] = 1;
        input[0][4] = 1;
        input[1][0] = 2;
        input[1][1] = 2;
        input[1][2] = 2;
        input[1][3] = 2;
        input[1][4] = 2;
        input[2][0] = 1;
        input[2][1] = 1;
        input[2][2] = 1;

        // 0,0
        // 1,1
        // 2,0
        // 3,1
        // 4,2
        // 5,1
        // 6,0
        // 7,1
        // 8,2
        // 9,3
        //int j = 0;
       /* int counter=1;
        for(int j=0;j<size;j++){
            pattern[j]=j;
            if(j==counter){
                counter++;
            }
        }*/
        int subSize = (size / 2) - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                finalOutput[i] = input[i][j];
            }

            //finalOutput[i] = input[i][pattern[i]];
            //j = j + 1;// instead of 1 there should be a pattern which helps to print above

        }


    }

}

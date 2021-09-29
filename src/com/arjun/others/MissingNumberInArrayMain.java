package com.arjun.others;

/**
 * Given an array of size N-1 such that it only contains distinct integers in the range of 1 to N.
 * Find the missing element.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * A[] = {1,2,3,5}
 * Output: 4
 * Example 2:
 * <p>
 * Input:
 * N = 10
 * A[] = {1,2,3,4,5,6,7,8,10}
 * Output: 9
 * <p>
 * Hint: Use the formula of sum of first N natural numbers.
 * <p>
 * int i, total;
 * total = (n + 1) * (n) / 2;
 * for (i = 0; i < n-1; i++)
 * total -= array[i];
 * return total;
 */

public class MissingNumberInArrayMain {

    static int missingNumber(int array[], int n) {
        int total = (n * (n + 1)) / 2;
        //IntStream.of(array).sorted().forEach(num->total-=num);
        for (int num : array) {
            total -= num;
        }
        return total;

        // int currentNum = 0;

        //  array = Arrays.stream(array).sorted().toArray();

       /* for (int i = 0; i < n - 1; i++) {
            if (array[i] != ++currentNum) {
                break;
            }
        }*/

   /*     for (int num : array) {

            if (++currentNum <= n && num != currentNum) {
                return currentNum;
            }

        }
        return array[currentNum - 1] == currentNum ? n : currentNum;*/
    }

    public static void main(String[] args) {
        System.out.println(MissingNumberInArrayMain.missingNumber(new int[]{1,3}, 3));
    }
}

package com.arjun.others;

public class TrailingZeroesInFactorialMain {
    /**
     *For an integer N find the number of trailing zeroes in N!.
     *
     ** Hint: Zero comes with 2*5 or 10
     *
     * Example 1:
     *
     * Input:
     * N = 5
     * Output:
     * 1
     * Explanation:
     * 5! = 120 so the number of trailing zero is 1.
     * Example 2:
     *
     *
     * Input:
     * N = 4
     * Output:
     * 0
     * Explanation:
     * 4! = 24 so the number of trailing zero is 0.
     *
     * Expected Time Complexity: O(logN)
     * Expected Auxiliary Space: O(1)
     *
     * Constraints:
     * 1 <= N <= 109
     *
     */
    static int trailingZeroes(int N) {
       /* // Write your code here
        int factorial = 1;
        int count = 0;
        for (int i = N; i >= 1; i--) {
            factorial *= i;
        }
        while (factorial % 10 == 0) {
            factorial/=10;
            count++;
        }
        return count;*/

     /*   if (N < 0) // Negative Number Edge Case
            return -1;

        // Initialize result
        int count = 0;

        // Keep dividing n by powers of
        // 5 and update count
        for (int i = 5; N / i >= 1; i *= 5)
            count += N / i;

        return count;*/

        int j=5;
        int ans=0;
        while(j<=N)
        {
            ans+= N/j;
            j=j*5;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(TrailingZeroesInFactorialMain.trailingZeroes(10));
    }
}

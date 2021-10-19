package com.arjun.features;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * In Scanner class if we call nextLine() method after any one of the seven nextXXX() method then the nextLine() does not read values from console and cursor will not come
 * into console it will skip that step. The nextXXX() methods are nextInt(), nextFloat(), nextByte(), nextShort(), nextDouble(), nextLong(), next().
 * In BufferReader class there is no such type of problem. This problem occurs only for Scanner class, due to nextXXX() methods ignore newline character and
 * nextLine() only reads till first newline character. If we use one more call of nextLine() method between nextXXX() and nextLine(),
 * then this problem will not occur because nextLine() will consume the newline character. See this for the corrected program.
 * This problem is same as scanf() followed by gets() in C/C++.
 * This problem can also be solved by using next() instead of nextLine() for taking input of strings as shown here.
 * Other differences:
 * <p>
 * <p>
 * BufferedReader is synchronous while Scanner is not. BufferedReader should be used if we are working with multiple threads.
 * BufferedReader has significantly larger buffer memory than Scanner.
 * The Scanner has a little buffer (1KB char buffer) as opposed to the BufferedReader (8KB byte buffer), but it’s more than enough.
 * BufferedReader is a bit faster as compared to scanner because scanner does parsing of input data and BufferedReader simply reads sequence of characters.
 */
public class ScannerBufferedReaderHandson {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an Integer");
        int a = scanner.nextInt();
        System.out.println("Enter a String");
        String b = scanner.nextLine();
        System.out.printf("You have entered:- " + a + " " + "and name as " + b);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an Integer");
        int a2 = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter a String");
        String b2 = bufferedReader.readLine();
        System.out.printf("You have entered:- " + a2 +
                " and name as " + b2);
    }
}

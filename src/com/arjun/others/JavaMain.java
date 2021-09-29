package com.arjun.others;

import java.util.Arrays;
import java.util.stream.IntStream;

public class JavaMain {


    public static void main(String[] args) {

        int firstEvenDoubleDivBy3 = IntStream.range(100, 200).map(n -> n * 2).filter(n->n%3==0).findFirst().orElse(0);

        String[] strings = "this is an array of strings".split(" ");
       int sum= Arrays.stream(strings)
                .mapToInt(String::length)
             .sum();


        System.out.println(sum);

        String s="Arjun";
        String backward=new StringBuilder(s).reverse().toString();
        if(s.equals(backward)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}

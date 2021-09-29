package com.arjun.features;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class StringHandson {

    public static void main(String args[]) {

        String s = "Accenture";
        System.out.println("Substring(1,5) - " + s.substring(1, 4));
        System.out.println("Substring(2) - " + s.substring(3));
        System.out.println("Sub sequence - " + s.subSequence(1, 4));
        System.out.println("CharAt(0) - " + s.charAt(0));
        System.out.println("Length - " + s.length());
        System.out.println("Lines - " + s.lines());
        System.out.println("CodePointAt(0) Unicode code point at index 0 - " + s.codePointAt(0));

        System.out.println("codePointCount(2,5) - " + s.codePointCount(2, 5));
        System.out.println("matches(ce) - " + s.matches("ce"));
        System.out.println("OffsetByCodePoints(2,3) - " + s.offsetByCodePoints(2, 3));
        System.out.println("repeat(2)" + s.repeat(3));
        System.out.println("regionMatches(2,cent,0,4)" + s.regionMatches(2, "cent", 0, 4));
        System.out.println("startsWith(Acc) - " + s.startsWith("Acc"));
        System.out.println("Locale.ENGLISH - " + Locale.ENGLISH);



        int firstEvenDoubleDivBy3 = IntStream.range(100, 200).map(n -> n * 2).filter(n->n%3==0).findFirst().orElse(0);

        String[] strings = "this is an array of strings".split(" ");
        int sum= Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();


        System.out.println(sum);

        String s1="Arjun";
        String backward=new StringBuilder(s).reverse().toString();
        if(s1.equals(backward)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

          /*   System.out.println(""+);
             System.out.println(""+);
              System.out.println(""+); System.out.println(""+);
               System.out.println(""+);
                System.out.println(""+);
                 System.out.println(""+);
                  System.out.println(""+);
                   System.out.println(""+);





        System.out.println(""+);*/


    }
}

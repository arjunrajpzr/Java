package com.arjun.java8features;

import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamsHandson {


    public static void main(String args[]) throws IOException {

        List<String> animals = Arrays.asList("Monkey", "Lion", "Giraffe", "Limor", "Lion", "Limor");

        List<String> distinctAnimals = animals.stream().distinct().collect(Collectors.toList());

        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5};

        Stream<Integer> intStr=Stream.of(intArray);
        //or
        //Arrays.stream(intArray);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> lAnimals = Stream.of("Monkey", "Lion", "Giraffe", "Limor")
                .filter(x -> x.startsWith("L"))
                .map(x -> x.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nSorted animal names starting with letter L - " + lAnimals);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> limitTwo = animals.stream()
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("\nFirst two animals from " + animals + " are - " + limitTwo);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> skipTwo = animals.stream().skip(2).collect(Collectors.toUnmodifiableList());

        System.out.println("\nElements after skipping first two elements from " + animals + " are - " + skipTwo);

        //skipTwo.add("Lion");          //java.lang.UnsupportedOperationException

        ///////////////////////////////////////////////////////////////////////////////////////////////////////


        System.out.println("\nDistinct " + animals + " are - " + distinctAnimals);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Stream<String> sortedComparatorString = animals.stream().sorted(Comparator.comparing(String::length));

        System.out.println("\nSorted " + animals + " using comparator - " + sortedComparatorString.collect(Collectors.toList()));

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        IntStream lengths = animals.stream().mapToInt(String::length);
        System.out.println("\nLength of " + animals + " using mapToInt - ");
        lengths.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Stream<Character> flatMapDemo = animals.stream().flatMap(x -> x.chars().mapToObj(i -> (char) i));
        System.out.println("\nFlat map demo - ");
        flatMapDemo.forEach(System.out::println);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\nForEach: ");
        animals.stream().forEach(System.out::println);
        System.out.println("\nForEachOrdered: ");
        animals.stream().forEachOrdered(System.out::println);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Set<String> animalSet = animals.stream().collect(Collectors.toSet());


        System.out.println("Set datastructure: " + animalSet);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> str = getPalindrome(Files.lines(Paths.get("C:/Users/ARBHA/Documents/Data/PalindromeTest.txt")), 5);

        System.out.println("Palindrome - " + str);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> strings = List.of("one","two","three","four");

        System.out.println("Creating a map from list");
        var map = strings.stream()
                .collect(groupingBy(String::length, counting()));
        map.forEach((key, value) -> System.out.println(key + " :: " + value));


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    private static List<String> getPalindrome(Stream<String> stream, int length) {
        return stream.filter(s -> s.length() == length)
                .filter(s -> s.compareToIgnoreCase(
                        new StringBuilder(s).reverse().toString()) == 0)
                .collect(Collectors.toList());
    }
}

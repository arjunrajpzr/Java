package com.arjun.java8features;


import com.arjun.business.Transaction;

import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.*;

public class StreamsHandson {


    public static void main(String args[]) throws IOException {

        List<String> animals = Arrays.asList("Monkey", "Lion", "Giraffe", "Limor", "Lion", "Limor");

        List<String> distinctAnimals = animals.stream().distinct().collect(toList());
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5};

        Stream<Integer> intStr = Stream.of(intArray);
        //or
        //Arrays.stream(intArray);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> lAnimals = Stream.of("Monkey", "Lion", "Giraffe", "Limor")
                .filter(x -> x.startsWith("L"))
                .map(x -> x.toUpperCase())
                .sorted()
                .collect(toList());

        System.out.println("\nSorted animal names starting with letter L - " + lAnimals);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> limitTwo = animals.stream()
                .limit(2)
                .collect(toList());

        System.out.println("\nFirst two animals from " + animals + " are - " + limitTwo);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> skipTwo = animals.stream().skip(2).collect(toUnmodifiableList());

        System.out.println("\nElements after skipping first two elements from " + animals + " are - " + skipTwo);

        //skipTwo.add("Lion");          //java.lang.UnsupportedOperationException

        ///////////////////////////////////////////////////////////////////////////////////////////////////////


        System.out.println("\nDistinct " + animals + " are - " + distinctAnimals);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Stream<String> sortedComparatorString = animals.stream().sorted(comparing(String::length));

        System.out.println("\nSorted " + animals + " using comparator - " + sortedComparatorString.collect(toList()));

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

        Set<String> animalSet = animals.stream().collect(toSet());


        System.out.println("Set datastructure: " + animalSet);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //List<String> str = getPalindrome(Files.lines(Paths.get("C:/Users/ARBHA/Documents/Data/PalindromeTest.txt")), 5);

        //  System.out.println("Palindrome - " + str);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<String> strings = List.of("one", "two", "three", "four");

        System.out.println("Creating a map from list");
        var map = strings.stream()
                .collect(groupingBy(String::length, counting()));
        map.forEach((key, value) -> System.out.println(key + " :: " + value));


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Transaction> transactions = new ArrayList<>();

        Transaction t1 = new Transaction(4, 100.0, com.arjun.Transaction.GROCERY);


        Transaction t2 = new Transaction(1, 10.20, com.arjun.Transaction.GROCERY);

        Transaction t3 = new Transaction(3, 46.90, com.arjun.Transaction.GROCERY);

        Transaction t4 = new Transaction(2, 10.20, com.arjun.Transaction.BAKERY);

        Transaction t5 = new Transaction(5, 32.2, com.arjun.Transaction.FRUIT);


        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);
        transactions.add(t4);
        transactions.add(t5);


        List<Integer> transactionsIds =
                transactions.stream()
                        .filter(t -> t.getType() == com.arjun.Transaction.GROCERY)
                        .sorted(comparing(Transaction::getTransactionValue).reversed())
                        .map(Transaction::getTransactionId)
                        .collect(toList());

        System.out.println("\n\t Transaction IDs: " + transactionsIds);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //IntStream.rangeClosed(0, 9)
        List<Integer> evenSquares = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(num -> {
            System.out.println("filtering " + num);
            return num % 2 == 0;
        }).map(num -> {
            System.out.println("Mapping " + num);
            return num * num;
        }).limit(3).collect(toList());

        System.out.println(evenSquares);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        boolean expensive = transactions.stream().allMatch(t -> t.getTransactionValue() > 10.0);

        System.out.println(expensive);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        transactions.stream().filter(t -> t.getType() == com.arjun.Transaction.GROCERY).map(t -> t.getTransactionId()).findAny().ifPresent(System.out::println);
//
        // Optional<Integer> tra = transactions.stream().filter(t -> t.getType() == com.arjun.Transaction.GROCERY).map(Transaction::getTransactionId).sorted(reverseOrder()).findFirst()
        // System.out.println(tra.get());
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //  Double sum=transactions.stream().filter(t->t.getType()== com.arjun.Transaction.GROCERY).map(t->t.getTransactionValue()).reduce(0.0,(a, b)->a+b);
        Double sum = transactions.stream().filter(t -> t.getType() == com.arjun.Transaction.GROCERY).mapToDouble(t -> t.getTransactionValue()).sum();
        System.out.println(sum);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Integer> listOfNumbers = Stream.iterate(1, n -> n + 10).limit(5).collect(toList());
        System.out.println(listOfNumbers);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        // produce a Map representing the number of occurrences of each character that appears in a stream of words
        Map<String, Long> letterToCount = Stream.of("Java", "Magazine", "is", "the", "best").map(w -> w.split("")).flatMap(Arrays::stream).collect(groupingBy(Function.identity(), counting()));
        System.out.println(letterToCount);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        Files.lines(Path.of("C:\\Users\\Arjun\\OneDrive\\Documents\\SampleTextFile.txt")).map(line -> line.split("\\s+")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        //Long count=transactions.stream().collect(Collectors.counting());
        //Long count=transactions.stream().count();
        Integer count = transactions.stream().collect(summingInt(Transaction::getTransactionId));
        System.out.println(count);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        transactions.stream().collect(maxBy(comparing(Transaction::getTransactionId))).ifPresent(System.out::println);


        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Map<Integer, List<Transaction>> transactionsByCurrencies =
                transactions.stream().collect(groupingBy(
                        Transaction::getTransactionId));
        System.out.println(transactionsByCurrencies);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Map<Boolean, List<Transaction>> partitionedTransactions =
                transactions.stream().collect(partitioningBy(
                        t -> t.getTransactionValue() > 33.0));

        System.out.println(partitionedTransactions);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Map<Integer, Transaction> collect = transactions.stream().collect(toMap(t -> t.getTransactionId(), Function.identity()));

        System.out.println(collect);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        Map<com.arjun.Transaction, Double> transactionSum =
                transactions.stream().collect(groupingBy(
                        Transaction::getType, Collectors.summingDouble(Transaction::getTransactionValue)));

        System.out.println(transactionSum);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
    }


    private static List<String> getPalindrome(Stream<String> stream, int length) {
        return stream.filter(s -> s.length() == length)
                .filter(s -> s.compareToIgnoreCase(
                        new StringBuilder(s).reverse().toString()) == 0)
                .collect(Collectors.toList());
    }

}

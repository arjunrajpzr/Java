package com.arjun.features;

import com.arjun.business.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class GenericsHandson {

    public static void tuplesDemo() {
        Tuple<Integer, String> tuple = new Tuple<>(1, "Hello");

        System.out.println(tuple);

        Tuple<LocalDate, List<String>> tuple1 = new Tuple<>(LocalDate.now(), Arrays.asList("a", "b", "c"));
        System.out.println(tuple1);

    }

    public static void pairDemo() {
        Pair<Integer> pair = new Pair<>(3, 4);
        System.out.println("Pair: " + pair);
        pair = pair.swap();
        System.out.println("Pair swap: " + pair);

        Pair<Integer> pair1 = new Pair<>(15, 19);
        System.out.println("Pair1: " + pair1);
        Pair.swap(pair1);
        System.out.println("Pair1 swap: " + pair1);

    }

    public static void hrDemo() {
        List<Employee> employees = Arrays.asList(
                new Employee("Bart"), new Employee("Homer"),
                new Employee("Lisa"), new Employee("Maggle"));

        List<Salaried> salaried=Arrays.asList(
                new Salaried("Kyle"),new Salaried("Stan"),
                new Salaried("Kenny"),new Salaried("Cartman"));

        System.out.println(employees);
        System.out.println(salaried);

        HR.printEmpNames(employees);
        //HR.printEmpNames(employees); // doesn't compile

        HR.printEmpAndSubclassNames(salaried);

        HR.printAllFiltered(employees, e->e.toString().length()%2==0);

        //PECS --> produces uses extends, consumes uses super
    }
}

package com.arjun.features;

import com.arjun.business.Employee;
import com.arjun.business.EmployeeIdComparator;
import com.arjun.business.EmployeeWithComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Comparable interface can be used to provide single way of sorting whereas
 * Comparator interface is used to provide multiple ways of sorting
 * <p>
 * Comparable provides compareTo() method to sort elements, whereas
 * Comparator provides compare() method to sort elements
 * <p>
 * At times, when you are using any third-party classes or the classes
 * where you are not the author of the class, then in that case
 * Comparator is the only choice to sort those objects
 */
public class ComparableAndComparatorHandson {
    public static void main(String[] args) {

        //Comparable handson
        //For using Comparable, the class needs to implement Comparable interface whereas
        List<EmployeeWithComparable> empList = new ArrayList<>();

        empList.add(new EmployeeWithComparable(5, "Arjun", 28));
        empList.add(new EmployeeWithComparable(1, "Raj", 27));
        empList.add(new EmployeeWithComparable(10, "Karthikeyan", 25));
        empList.add(new EmployeeWithComparable(15, "Kapilan", 20));
        empList.add(new EmployeeWithComparable(4, "Parasharan", 33));

        Collections.sort(empList);
        System.out.println(empList);


        //Comparator handson
        //For using Comparator, there is no need to make changes in the class
        List<Employee> empListUsingComparator = new ArrayList<>();
        empListUsingComparator.add(new Employee(5, "Arjun", 28));
        empListUsingComparator.add(new Employee(1, "Raj", 28));
        empListUsingComparator.add(new Employee(10, "Karthikeyan", 25));
        empListUsingComparator.add(new Employee(15, "Kapilan", 20));
        empListUsingComparator.add(new Employee(4, "Parasharan", 33));
        empListUsingComparator.add(new Employee(2, "Raj", 27));

        //same scenario as demonstrated in Comparable using EmployeeIdComparator
        Collections.sort(empListUsingComparator, new EmployeeIdComparator());

        //same scenario as demonstrated in Comparable using Lambda Expressions
        //Collections.sort(empListUsingComparator, (emp1,emp2)->emp1.getId()-emp2.getId());


        // Compare a list of Employees based on name and age such that if name of the employee is same then sorting should be based on age
  /*      Collections.sort(empListUsingComparator, (emp1, emp2) -> {
            int result = emp1.getName().compareTo(emp2.getName());
            return result == 0 ? emp1.getAge() - emp2.getAge() : result;
        });*/


        //Same scenario with name in descending order
        /*  Collections.sort(empListUsingComparator, (emp1, emp2) -> {
            int result = emp2.getName().compareTo(emp1.getName());
            return result == 0 ? emp1.getAge() - emp2.getAge() : result;
        });*/

        System.out.println("\n" + empListUsingComparator);

    }
}

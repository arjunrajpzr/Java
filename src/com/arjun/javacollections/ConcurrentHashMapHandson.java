package com.arjun.javacollections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Key points of ConcurrentHashMap:
 * <p>
 * The underlined data structure for ConcurrentHashMap is Hashtable.
 * ConcurrentHashMap class is thread-safe i.e. multiple threads can operate on a single object without any complications.
 * At a time any number of threads are applicable for a read operation without locking the ConcurrentHashMap object which is not there in HashMap.
 * In ConcurrentHashMap, the Object is divided into a number of segments according to the concurrency level.
 * The default concurrency-level of ConcurrentHashMap is 16.
 * In ConcurrentHashMap, at a time any number of threads can perform retrieval operation
 * but for updated in the object, the thread must lock the particular segment in which the thread
 * wants to operate. This type of locking mechanism is known as Segment locking or bucket locking.
 * Hence at a time, 16 update operations can be performed by threads.
 * Inserting null objects is not possible in ConcurrentHashMap as a key or value.
 *
 */
public class ConcurrentHashMapHandson {

    public static void main(String[] args) {
        //Creates a new, empty map with the specified initial capacity,
        // and with default load factor (0.75)
        // and concurrencyLevel (16).
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "Hello");
        concurrentHashMap.put(2, "welcome");
        concurrentHashMap.put(3, "to");
        concurrentHashMap.put(4, "ooty");

        // Here we cant add Hello because 1 key
        // is already present in ConcurrentHashMap object
        concurrentHashMap.putIfAbsent(2, "welcome");


        //***************Removing Elements *************************
        // We can remove entry because 3 key
        // is associated with For value
        String valueRemoved = concurrentHashMap.remove(3);

        // Now we can add Nice to meet you
        concurrentHashMap.putIfAbsent(5, "Nice to meet you");

        // We cant replace to with from
        concurrentHashMap.replace(3, "to", "from");

        System.out.println(concurrentHashMap);
        System.out.println("Value removed from concurrentHashMap: " + valueRemoved);

        //*************** Accessing the Elements *************************
        // Display the value of 1
        System.out.println("The Value associated to "
                + "1 is : " + concurrentHashMap.get(1));

        //*************** Traversing *************************
        System.out.println("\nconcurrentHashMap Traversal");
/*
        Iterator<Map.Entry<Integer, String>> iterator = concurrentHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println("Key = " + entry.getKey()
                    + ", Value = " + entry.getValue());
        }
*/

        concurrentHashMap.entrySet().stream().peek(entry -> System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue())).close();

        ConcurrentHashMap<Integer, String> concurrentHashMap1 = new ConcurrentHashMap<>();
        //***************Adding Elements *************************
        // copy mappings from concurrentHashMap to concurrentHashMap1
        concurrentHashMap1.putAll(concurrentHashMap);

        System.out.println(concurrentHashMap1);

        // Removing the mapping
        // with non-existing key 10
        // using remove() method
        valueRemoved = concurrentHashMap1.remove("10");
        System.out.println("\nValue removed from concurrentHashMap1: " + valueRemoved);

        // Now clear the map using clear()
        concurrentHashMap1.clear();
        System.out.println("concurrentHashMap1 cleared\n" + concurrentHashMap1);

    }
}

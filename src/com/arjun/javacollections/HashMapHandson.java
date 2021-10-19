package com.arjun.javacollections;

import java.util.*;

import static java.util.Map.entry;

/**
 * You should be extremely careful when choosing the type of the keys for your maps.
 * In a nutshell, choosing a mutable key is not prohibited but is dangerous and discouraged.
 * Once a key has been added to a map, mutating it may lead to changing its hash code value, and its identity.
 * This may make your key-value pair unrecoverable or may get you a different value when querying your map.
 */
public class HashMapHandson {
    public static void main(String[] args) {

        // Using the Convenience Factory Methods for Collections to Create Maps
        // There are restrictions on these maps and entries created by these factory methods, as for the sets:
        //
        //    The map and the entries you get are immutable objects
        //    Null entries, null keys, and null values are not allowed
        //    Trying to create a map with duplicate keys in this way does not make sense, so as a warning you will get an IllegalArgumentException at map creation.

        // There is one caveat though: you can only use this pattern if you have no more than 10 key-value pairs.
        mapFactoryMethodsDemo();

        removeMethodsInHashMapDemo();

        getOrDefaultInHashMapDemo();

        mapLambdaImplDemo();

    }

    private static void mapLambdaImplDemo() {
        Map<Integer, String> map7 = new HashMap<>();
        map7.put(1, "one");
        map7.put(2, "two");
        map7.put(3, "three");

        // forEach() method takes a BiConsumer as an argument instead of a simple Consumer.
        map7.forEach((key, value) -> System.out.println("Key=" + key + ", value=" + value));


        //replacing values
        map7.replace(2, "twoo");
        map7.replace(2, "three", "threee");

        System.out.println("\n\n");
        map7.replaceAll((key, value) -> value.toUpperCase());
        map7.forEach((key, value) -> System.out.println("Key=" + key + ", value=" + value));


        // print this pattern
        // 3 :: [one, two, six]
        // 4 :: [four, five]
        // 5 :: [three, seven]
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven");

        // How does this code work?
        //
        //    If the key is not in the map, then the mapping function is called, which creates an empty list. This list is returned by the computeIfAbsent() method.
        //      This is the empty list in which the code adds word.
        //    If the key is in the map, the mapping function is not called, and the current value bound to that key is returned.
        //      This is the partially filled list in which you need to add word.


        // This code is much more efficient than the putIfAbsent() one, mostly because in that case, the empty list is created only if needed.
        //      The putIfAbsent() call requires an existing empty list, which is used only if the key is not in the map.
        Map<Integer, List<String>> map8 = new HashMap<>();
        for (String word : strings) {
            int length = word.length();
            map8.computeIfAbsent(length, key -> new ArrayList<>()).add(word);
        }

        map8.forEach((key, value) -> System.out.println(key + " :: " + value));

        // print this pattern
        // 3 :: one, two, six
        // 4 :: four, five
        // 5 :: three, seven


        // If the key is not in the map or bound to a null value, then the value is bound to that key. The remapping function is not called in this case.
        // On the contrary, if the key is already bound to a non-null value, then the remapping function is called with the existing value,
        // and the new value passed as an argument. If this remapping function returns null, then the key is removed from the map. The value it produces is bound to that key otherwise.

        Map<Integer, String> map9 = new HashMap<>();

        for (String word : strings) {
            int length = word.length();
            map9.merge(length, word, (existingValue, newWord) -> existingValue + ", " + newWord);
        }

        map9.forEach((key, value) -> System.out.println(key + " :: " + value));
    }

    private static Map<Integer, String> getOrDefaultInHashMapDemo() {
        Map<Integer, String> map5 = new HashMap<>();

        map5.put(1, "one");
        map5.put(2, "two");
        map5.put(3, "three");
        map5.put(4, null);
        map5.put(3, "four");

        List<String> values1 = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            values1.add(map5.getOrDefault(i, "UNDEFINED"));
        }

        Set<Integer> keys = map5.keySet();
        System.out.println("keys = " + keys);

        Collection<String> values2 = map5.values();
        System.out.println("values = " + values1);

        Set<Map.Entry<Integer, String>> entries = map5.entrySet();
        System.out.println("entries = " + entries);
        return map5;
    }

    private static void removeMethodsInHashMapDemo() {
        Map<Integer, String> map6 =
                Map.ofEntries(
                        Map.entry(1, "one"),
                        Map.entry(2, "two"),
                        Map.entry(3, "three"),
                        Map.entry(4, "three"),
                        Map.entry(5, "four")
                );
        map6 = new HashMap<>(map6);
        System.out.println("map = " + map6);
        //Removing a Key From the Set of Keys
        map6.remove(5);

        //Removing a Value From the Collection of Values
        //You need to be careful in this case because if the implementation you chose is a HashMap, you cannot tell in advance what key/value pair will be found.
        map6.values().remove("three");

        System.out.println("map after key 4 and value three removed = " + map6);

        for (Map.Entry<Integer, String> entry : map6.entrySet()) {
            System.out.println("entry = " + entry);
        }
    }

    private static void mapFactoryMethodsDemo() {
        Map<String, String> map1 = Map.of("1", "Arjun", "2", "Arjun", "3", "Arjun", "4", "Arjun", "5", "Arjun", "6", "Arjun", "7", "Arjun", "8", "Arjun", "9", "Arjun", "10", "Arjun");


        Map.Entry<Integer, String> e1 = entry(1, "one");
        Map.Entry<Integer, String> e2 = entry(2, "two");
        Map.Entry<Integer, String> e3 = entry(3, "three");

        Map<Integer, String> map2 = Map.ofEntries(e1, e2, e3);

        Map<Integer, String> map3 =
                Map.ofEntries(
                        entry(1, "one"),
                        entry(2, "two"),
                        entry(3, "three")
                );


        Map<String, Integer> map4 = new HashMap<>();

        map4.put("one", 1);
        map4.put("two", null);
        map4.put("three", 3);
        map4.put("four", null);
        map4.put("five", 5);
        // map.values() is a Collection<Integer>. So iterating on this collection produces instances of Integer.
        // Because you declared value as an int, the compiler will auto-unbox this Integer to an int value.
        // This mechanism fails with a NullPointerException if the instance of Integer is null.
    /*    for (int value : map4.values()) {
            System.out.println("value = " + value);
        }*/

        //You may fix this map with the following code, which replaces the faulty null values with a default value,
        // that will not generate any NullPointerException anymore.
        for (String key : map4.keySet()) {
            map4.putIfAbsent(key, -1);
        }
    }
}

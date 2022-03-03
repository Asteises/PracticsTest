package ru.asteises;

import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {


        List<String> stringList = List.of("Adam", "Tom", "Adam", "Anna", "Bill", "Anna", "Tom");
        List<Integer> integerList = List.of(22, 54, 11, 90, 8, 12, 85);
        String s = " new ";

//        List<String> stringListB = stringList.stream().filter(x -> x.charAt(0) == 'B').toList();
//        long i = stringList.stream().filter(x -> x.length() == 3).count();
//        stringList.stream().sorted().forEach(x -> System.out.println(x));
//        integerList.stream().map(x -> {
//            if (x > 50) {
//                x *= 2;
//            } else {
//                x *= 3;
//            }
//            return x;
//        }).forEach(x -> System.out.println(x));
//
//        Map<String, Integer> map = new HashMap<>();
//
//        map.put("Test", 10);
//
//        //
//        map.get("Test");
//        int i = map.get("Test");
//        i++;
//
//        map.put("Test", i);

        Set<String> testSet = new HashSet<>();
        List<String> test = List.of("qwe", "asd", "qwe", "asd", "zxc");
        for (String listString : test) {
            testSet.add(listString);
        }

        TextTest textTest = new TextTest();
        textTest.count();
    }
}

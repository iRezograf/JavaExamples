package org.example.stepik.collections;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListExample {
    public static void main(String[] args) {
        List<String> listA = new ArrayList<>();
        listA.add("string 1");
        listA.add("string 2");
        listA.add("string 3");
        Collections.sort(listA, (t1, t2) -> t2.compareTo(t1));
        listA.forEach(System.out::println);

//        List<Integer> listB = List.of(100, 400, 200, 300); //ImmutableCollections не сортируется
        List<Integer> listB = new ArrayList<>();
        listB.add(1);
        listB.add(2);

        listB.forEach(System.out::println);
        System.out.println("----- after sort ------");
        Collections.sort(listB, (t1, t2) -> t2.compareTo(t1));
        listB.forEach(System.out::println);

        List<String> listC = new ArrayList<>(listA);
        listC.replaceAll(e -> "listC: " + e);
        listC.forEach(System.out::println);

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);

        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100
        IntStream range = IntStream.range(10, 15); // 10 .. 99
        range.forEach(System.out::println);



        ;
    }
}
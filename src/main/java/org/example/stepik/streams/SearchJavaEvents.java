package org.example.stepik.streams;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SearchJavaEvents {

    public static void printSortedJavaEvents(List<String> events) {
        events.stream()
                .filter(e->e.toLowerCase().contains("java"))
                .sorted()
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        List<String> events = List.of("JavaZone","KotlinConf","java night party | Amsterdam",
         "Day of Java","PyCon US");

//        Scanner scanner = new Scanner(System.in);

//        List<String> events = Stream
//                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
//                .map(i -> scanner.nextLine())
//                .collect(Collectors.toList());

        printSortedJavaEvents(events);

        List<Integer> numbers = List.of(40, 81, 27, 86, 79,87);
        System.out.println(numbers.stream()
                .filter(n->n%2 ==0)
//                .max((a,b)->a-b)
                .max(Integer::compare)
                .orElse(0));

        List<Integer> number = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6);
        number.stream()
                .filter(n -> n > -5 && n <= 5)
                .filter(n -> n < 0 || n > 2)
                .forEach(System.out::println);
    }
}
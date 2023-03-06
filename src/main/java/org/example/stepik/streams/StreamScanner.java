package org.example.stepik.streams;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamScanner {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                List<String> events = Stream
                        .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                        .map(i -> scanner.nextLine())
                        .collect(Collectors.toList());

                events.stream().forEach(System.out::println);


        }




}

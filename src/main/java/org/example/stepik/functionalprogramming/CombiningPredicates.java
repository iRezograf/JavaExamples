package org.example.stepik.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class CombiningPredicates {
    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
//        if (predicates.isEmpty()) {
//            return (a) -> true;
//        }
//        IntPredicate intpa = (a) -> true;
//        for (IntPredicate intp : predicates) {
//            intpa = intpa.and(intp);
//        }
//        return intpa; // write your code here

/**        return predicates.stream()
                .reduce(IntPredicate::and)
                .orElse(value -> true);*/

        return predicates.stream().reduce(a->true, (a,b) -> a.and(b));
    }


    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = stream(strings)
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

/**        мой пример офф топик
//        IntPredicate isOdd = n -> n % 2 != 0;
//        System.out.println(isOdd.test(14));
 **/

        System.out.println(conjunctAll(predicates).test(1));
    }

    private static boolean isOdd(int i) {
        return i % 2 == 0;
    }
}


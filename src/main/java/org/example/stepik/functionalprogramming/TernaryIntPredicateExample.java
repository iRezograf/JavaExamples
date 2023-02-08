package org.example.stepik.functionalprogramming;



import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TernaryIntPredicateExample {




    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (i1, i2, i3) -> Stream.of(i1, i2, i3).collect(Collectors.toSet()).size() > 2;

    /***    ниже та же конструкция, что наверху, но решенная без стрима: ***/
//    public static final TernaryIntPredicate allValuesAreDifferentPredicate = new TernaryIntPredicate() {
//        @Override
//        public Boolean test(Integer i1, Integer i2, Integer i3) {
//            return Stream.of(i1, i2, i3).collect(Collectors.toSet()).size() >2;
//            Set<Integer> set = new HashSet<>();
//            set.add(i1);
//            set.add(i2);
//            set.add(i3);
//            return set.size() > 2;

// }
    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1, 2, 3) ? "true" : "false");

        /** тернарный аператор */
        Function<Integer, Integer> f = x -> x * x; // очередность #2
        Function<Integer, Integer> g = x -> 2 * x; // очередность #3
        Function<Integer, Integer> h = x -> x + 7; // очередность #1
        // g(f(h(x)))
        System.out.println(f.andThen(g).compose(h).apply(3)); // 2*( (x+7)*(x+7) )=200


        /*** Composite PREDOCATES ***/
        System.out.println("-------  Composite PREDOCATES ------------");
        IntPredicate isEven = n -> n % 2 == 0; // it's true for 0, 2, 4, 6, 8 and so on

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(11)); // false

        IntPredicate lessThan11 = n -> n < 11; // it's true for all numbers < 11

        System.out.println(lessThan11.test(10)); // true
        System.out.println(lessThan11.test(11)); // false
//        Let's consider the negate method that returns a new predicate representing the logical negation of this predicate:

        IntPredicate isOdd = isEven.negate(); // it's true for 1, 3, 5, 7, 9 and so on

        System.out.println(isOdd.test(10));  // false
        System.out.println(isOdd.test(11));  // true
//        The methods or and and are equivalent to the standard logical operators || and &&, but they work with functions instead of values. Let's combine both isOdd and lessThan11 predicates together using them:

        IntPredicate isOddOrLessThan11 = isOdd.or(lessThan11);

        System.out.println(isOddOrLessThan11.test(10)); // true
        System.out.println(isOddOrLessThan11.test(11)); // true
        System.out.println(isOddOrLessThan11.test(12)); // false
        System.out.println(isOddOrLessThan11.test(13)); // true

        IntPredicate isOddAndLessThan11 = isOdd.and(lessThan11);

        System.out.println(isOddAndLessThan11.test(8));  // false
        System.out.println(isOddAndLessThan11.test(9));  // true
        System.out.println(isOddAndLessThan11.test(10)); // false
        System.out.println(isOddAndLessThan11.test(11)); // false

        System.out.println(" -------------------- ");
        Predicate<Character> isLetter = Character::isLetter;
        Predicate<Character> isUpperCase = Character::isUpperCase;
//        How to compose the predicates so that the new predicate can return the following results?

        Predicate<Character> predicate = isLetter.and(isUpperCase.negate()); // the composed predicate

        System.out.println(predicate.test('1')); // false
        System.out.println(predicate.test('3')); // false
        System.out.println(predicate.test('c')); // true
        System.out.println(predicate.test('D')); // false
        System.out.println(predicate.test('e')); // true
        System.out.println(predicate.test('Q')); // false

        System.out.println("------------------ test xor -----------------");
        IntPredicate Even = n -> (n % 2) == 0; // it's true for 0, 2, 4, 6, 8 and so on
        IntPredicate less11 = n -> n < 11; // it's true for all numbers < 11

        System.out.println(xor(Even, less11).test(14)); // true, true -> false);
    }
    /** In this task you need to create the xor operation using all of and, or and not.
     * //        There are several ways how to get it but the simplest one is just to follow the formula:
     * //        A or B, but not(A and B).
    */
    public static final  IntPredicate xor  (IntPredicate p1, IntPredicate p2) {
        return p1.and(p2).negate().and(p1.or(p2)); // write your code here
    }


    @FunctionalInterface
    public interface TernaryIntPredicate {
        Boolean test(Integer i1, Integer i2, Integer i3);
    }

}





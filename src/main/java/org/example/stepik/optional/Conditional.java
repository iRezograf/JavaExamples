package org.example.stepik.optional;

import java.util.Optional;

public class Conditional {
    public static void main(String[] args) {

        String str = null;
        Optional<String> StrVersion = Optional.ofNullable(str); // удобно использовать для return Optional<T> getField
        StrVersion.ifPresentOrElse(v-> System.out.println(v), ()-> System.out.println("strVersion exists"));


        Optional<String> versionHello = Optional.of("Hello my friend");
        /** to create an empty Optional, we can invoke the static empty method */
        versionHello.ifPresent(v-> System.out.println(v.split(" ")[0].toUpperCase()));
        Optional<String> version = Optional.empty();
        version.ifPresent(v-> System.out.println(v.split(" ")[0].toUpperCase()));

        Optional<String> versionEmpty = Optional.empty();
        version.ifPresentOrElse(v-> System.out.println(v), ()-> System.out.println("versionEmpty does not exist"));

        Optional<String> versionNotEmpty = Optional.of("versionNotEmpty Exist");
        version.ifPresentOrElse(v-> System.out.println(v), ()-> System.out.println("versionNotEmpty exists"));

        Optional<String> version1 = Optional.of("T-1000");
        version1.or(() -> Optional.of("T-600")); // returns Optional["T-1000"]

        /** version1.equals(Optional.of("T-1000")) cтрока не эквивалентна Optional*/
        System.out.println(version1.equals(Optional.of("T-1000"))); //true
        System.out.println(version1.equals("T-1000")); //false

        Optional<String> version2 = Optional.empty();
        System.out.println(
            version2.or(() -> Optional.of("T-600")) // returns Optional["T-600"]
        );
    }
}

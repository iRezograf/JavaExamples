package org.example.stepik.optional;

import java.util.Optional;

public class Filtering {
    public static void main(String[] args) {
        final String searchStr = "Exist";
        String searchSource = "String Optional";
        Optional<String> stringOptional = Optional.of(searchSource);

        stringOptional.filter(s -> s.contains(searchStr));

        System.out.println("-- " + stringOptional.filter(s -> s.contains(searchStr)) + " --");
    }
}

package org.example.w3chools;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterExample {
    public static void main(String args[]) {
        List<Student> list = new ArrayList<Student>();

        //Adding Students
        list.add(new Student(1, "Nidhi"));
        list.add(new Student(3, "Parbhjot"));
        list.add(new Student(2, "Amani"));

        // using lambda to filter data
        Stream<Student> filtered_data = list.stream().filter(s -> s.rollNo > 2);

        // using lambda to iterate through collection
        filtered_data.forEach(
                student -> System.out.println(student.name)
        );

        System.out.println("--------- Alternate record in one line ------");
        list.stream()
                .filter(s -> s.rollNo == 2)
                .forEach(s -> System.out.println(s.name));

        System.out.println("-------- очень смешно с weatherIsGood -------");
        List<Integer> famousNumbers = new ArrayList<>(List.of(0, 1, 1, 2, 3, 5, 8, 13));
        //famousNumbers.removeIf(n -> n > 2 && n < 8);
        Boolean weatherIsGood =true;

        Predicate <Integer> predicate = weatherIsGood ? n -> n % 2 == 0 : n -> n > 1;
        famousNumbers.removeIf(predicate);
        famousNumbers.stream().forEach(System.out::println);
    }

}


class Student {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        super();
        this.rollNo = rollNo;
        this.name = name;
    }
}






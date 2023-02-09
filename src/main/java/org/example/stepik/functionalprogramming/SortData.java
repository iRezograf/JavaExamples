package org.example.stepik.functionalprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortData {
    public static void main(String[] args) {
        SortData sd = new SortData();

        ArrayList<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("HP", 4, 15.6));
        laptops.add(new Laptop("Apple", 6, 15.6));
        laptops.add(new Laptop("Asus", 4, 14.1));
        laptops.add(new Laptop("Dell", 8, 17.0));
        laptops.add(new Laptop("Old but work", 1, 15.1));

        System.out.println("---------- by ascending ---------------");
        Comparator<Laptop> laptopComparatorNumberOfCores = (lt1,lt2)->
            Integer.compare(lt1.getNumberOfCores(), lt2.getNumberOfCores());
        laptops.stream()
                .sorted(laptopComparatorNumberOfCores)
                .forEach(System.out::println);

        System.out.println("---------- by descending ---------------");
        laptopComparatorNumberOfCores = (lt1,lt2)->
                Integer.compare(lt2.getNumberOfCores(), lt1.getNumberOfCores());
        laptops.stream()
                .sorted(laptopComparatorNumberOfCores)
                .forEach(System.out::println);

        System.out.println("----------- using comparingInt()  --------------");
//        there's possible use to comparing(), but comparingInt:
//        Comparator<Laptop> byNumberOfCores =
//                Comparator.comparing(Laptop::getNumberOfCores);
        Comparator<Laptop> byNumberOfCores =
                Comparator.comparingInt(Laptop::getNumberOfCores);
        laptops.sort(byNumberOfCores);
        laptops.forEach(System.out::println);

        System.out.println("-------------- comparingInt.reversed() -----------");
        byNumberOfCores = Comparator.comparingInt(Laptop::getNumberOfCores).reversed(); //comparingInt
        laptops.sort(byNumberOfCores);
        laptops.forEach(System.out::println);

        System.out.println("----------- using comparing(Brand)  --------------");
        Comparator<Laptop> byAnyField =
                Comparator.comparing(Laptop::getBrand); //comparing
        laptops.stream()
                .sorted(byAnyField)
                .forEach(System.out::println);

        System.out.println("----------- using comparing(Size).reversed()  --------------");
        byAnyField =
                Comparator.comparingDouble(Laptop::getDisplaySize).reversed(); //comparingDouble
        laptops.stream()
                .sorted(byAnyField)
                .forEach(System.out::println);


        laptops.sort(Comparator.comparing(Laptop::getNumberOfCores, Comparator.reverseOrder())
                .thenComparing(Laptop::getDisplaySize));
        laptops.forEach(System.out::println);

        System.out.println(" ----------- сортировка по длине слова ------------");
        ArrayList<String> words = new ArrayList<>();
        words.add("сублимация");
        words.add("эхо");
        words.add("время");
        words.add("европарламентаризм");

        words.sort(Comparator.comparingInt(String::length).reversed());
        words.forEach(System.out::println);

        System.out.println("------------сложная сортировка ---------------");
        laptops.sort(Comparator.comparing(Laptop::getNumberOfCores, Comparator.reverseOrder())
                .thenComparing(Laptop::getDisplaySize, Comparator.reverseOrder()));
        laptops.forEach(System.out::println);

        System.out.println("------------сложная сортировка ---------------");
        laptops.sort(Comparator.comparing(Laptop::getNumberOfCores, Comparator.reverseOrder())
                .thenComparing(Laptop::getDisplaySize, Comparator.reverseOrder()));
        laptops.forEach(System.out::println);
    }


}
class Laptop {
    private final String brand;
    private final int numberOfCores;
    private final double displaySize;

    Laptop(String brand, int numberOfCores, double displaySize) {
        this.brand = brand;
        this.numberOfCores = numberOfCores;
        this.displaySize = displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    @Override
    public String toString() {
        //  очень хороший форматированный вывод
        return String.format("Laptop{ brand = %15s numberOfCores= %s displaySize= %s", "'"+brand+"'",numberOfCores,displaySize);
    }

    // constructor, getters and toString
}
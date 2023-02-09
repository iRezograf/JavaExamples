package org.example.stepik.functionalprogramming;
import java.util.Scanner;
import java.util.function.Function;

class Emailing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sender = scanner.nextLine();
        String receiver = scanner.nextLine();
        String signature = scanner.nextLine();

        Function<String, String> emailFormatter = text -> text.concat("|"); // modify the lambda expression
        System.out.print(emailFormatter.apply(sender));
        System.out.print(emailFormatter.apply(receiver));
        System.out.print(emailFormatter.apply(scanner.nextLine()));
        System.out.println(signature);

    }
}

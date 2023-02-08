package org.example.stepik.functionalprogramming;

import java.util.*;

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

public class PhoneBook {

    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        List<PhoneNumber> claraPhoneNumbers = new ArrayList<>();
        claraPhoneNumbers.add(new PhoneNumber(PhoneNumberType.HOME, "723324324"));
        phoneBook.addNewPhoneNumbers("Clara", claraPhoneNumbers);

        List<PhoneNumber> kevinPhoneNumbers = new ArrayList<>();
        kevinPhoneNumbers.add(new PhoneNumber(PhoneNumberType.WORK, "1231"));
        phoneBook.addNewPhoneNumbers("Kevin", kevinPhoneNumbers);

        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "23424279")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

        phoneBook.printPhoneBook();
    }
    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.put(name, numbers);
        numbers.stream()
//                .filter(n->n.equals(name))
                .forEach(System.out::println);
        // write your code here
    }

    public void printPhoneBook() {
        nameToPhoneNumbersMap.keySet().forEach(System.out::println);
        System.out.println("----");
        nameToPhoneNumbersMap.entrySet().forEach(entry-> System.out.println(entry.getKey() +  "\n" + entry.getValue()));
        System.out.println("----");
        nameToPhoneNumbersMap.forEach((key,value)-> {
   
            System.out.println(key);
            value.forEach(System.out::println);
        });
        // write your code here
    }
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return type + ":" + number + '\n';
    }
}

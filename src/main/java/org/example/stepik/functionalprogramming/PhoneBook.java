package org.example.stepik.functionalprogramming;

import java.util.*;

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

public class PhoneBook {

    @Override
    public String toString() {
        return "PhoneBook{" +
                "nameToPhoneNumbersMap=" + nameToPhoneNumbersMap +
                '}';
    }

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
        phoneBook.addNewPhoneNumbers("Clara", List.of(new PhoneNumber(PhoneNumberType.MOBILE, "00000002")));
        phoneBook.addNewPhoneNumbers("Paul", List.of(new PhoneNumber(PhoneNumberType.WORK, "56756335")));

//        phoneBook.nameToPhoneNumbersMap.entrySet().forEach(System.out::println);
//        System.out.println(phoneBook.nameToPhoneNumbersMap);
        phoneBook.printPhoneBook();
    }
    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
//        nameToPhoneNumbersMap.computeIfAbsent(name, k -> new ArrayList<>()).addAll(numbers); /** не понимаю!!!, но работает !!! **/
        if (nameToPhoneNumbersMap.containsKey(name))
                nameToPhoneNumbersMap.get(name).addAll(numbers);
        else{
            nameToPhoneNumbersMap.put(name, numbers);
        }
    }
    public void printPhoneBook() {
        nameToPhoneNumbersMap.entrySet().forEach(entry-> {
            System.out.println(entry.getKey());
            entry.getValue().forEach(System.out::println);});
    }
/**
 *  public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.computeIfAbsent(name, k -> new ArrayList<>()).addAll(numbers);
    }

    public void printPhoneBook() {
        nameToPhoneNumbersMap.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(e -> System.out.println(e.getType() + ": " + e.getNumber()));
        });
    }
 */
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
        return type + ": " + number;
    }
}

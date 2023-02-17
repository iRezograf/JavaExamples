package org.example.stepik.optional;
import java.util.*;

import static org.example.stepik.optional.FindUserOptional.findUserByAccountId;

public class PrintUserIfProOptional {
    public static void main(String[] args) {

        Set<User> usersSet = new HashSet<>();

        usersSet.add(new User("user1", new Account("1", "pro")));
        usersSet.add(new User("user2", new Account("2","user")));
        usersSet.add(new User("user3", new Account("3","pro")));

        printLoginIfPro(usersSet, "3");

    }
    public static void printLoginIfPro(Set<User> users, String id) {

        Optional<User> user = findUserByAccountId(users, id);
//        System.out.println(user.get().getAccount().get().getType().equals("pro"));
        if (user
                .flatMap(User::getAccount)
                .map(Account::getType)
                .map("pro"::equals)
                .orElse(false)) {
            System.out.println(user.get().getLogin());
        }
    }

}




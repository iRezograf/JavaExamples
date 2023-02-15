package org.example.stepik.optional;

import java.util.*;

class FindUserOptional {
    public static void main(String[] args) {

        Set<User> usersSet = new HashSet<>();
        usersSet.add(new User("user1", new Account("1")));
        usersSet.add(new User("user2", new Account("2")));
        usersSet.add(new User("user3", new Account("3")));
        usersSet.add(new User("user4", new Account("4")));

//
//        usersSet.stream()
//                .forEach(u->u.getAccount()
//                        .map(a->a.getType())
//                        .ifPresent(t-> System.out.println(t)));

        System.out.println( findUserByAccountId(usersSet, "3") );
    }

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        //      красивое решение
        return users.stream()
                .filter(user -> user.getAccount()
                        .map(Account::getId)
                        .map(id::equals)
                        .orElse(false))
                .findAny();

        // * мое решение
        //        return users.stream()
        //                .filter(u->u.getAccount()
        //                .get().getId()
        //                .equals(id))
        //                .findFirst();

    }
}


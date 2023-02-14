package org.example.stepik.optional;

import java.util.*;

class FindUserOptional {
    public static void main(String[] args) {

        Set<User> usersSet = new HashSet<>();
        usersSet.add(new User("user1", new Account("1")));
        usersSet.add(new User("user2", new Account("2")));
        usersSet.add(new User("user3", new Account("3")));

        System.out.println( findUserByAccountId(usersSet, "2") );
    }

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        //      красивое решение
        return users.stream()
                .filter(user -> user.getAccount()
                        .map(Account::getId)
                        .map(id::equals)
                        .orElse(false))
                .findAny();


/**
// * мое решение
//        return users.stream()
//                .filter(u->u.getAccount().get().getId().equals(id)).findFirst();
*/
    }
}

class Account {
    private final String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                '}';
    }
}

class User {
    private final String login;
    private final Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", account=" + account +
                '}';
    }
}
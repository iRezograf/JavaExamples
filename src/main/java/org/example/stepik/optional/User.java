package org.example.stepik.optional;

import java.util.Objects;
import java.util.Optional;

public class User {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(account, user.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, account);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", account=" + account +
                '}';
    }
}
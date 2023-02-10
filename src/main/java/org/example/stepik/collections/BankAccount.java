package org.example.stepik.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class AccountSortEx {
    public static void main(String[] args) {


        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new BankAccount("Peter", 1000L, false));
        accounts.add(new BankAccount("John", 1000L, false));
        accounts.add(new BankAccount("Ivan", 8000L, true));
        accounts.add(new BankAccount("Helen", 5000L, false));
        accounts.add(new BankAccount("Nicole", 3000L, true));

        accounts.sort(BankAccount.getComparatorByLockedBalanceAndOwner());

        accounts.forEach(System.out::println);
    }
}

public class BankAccount {
    private final String owner;
    private final long balance;
    private final boolean locked;

    public BankAccount(String owner, long balance, boolean locked) {
        this.owner = owner;
        this.balance = balance;
        this.locked = locked;
    }

    public static Comparator<BankAccount> getComparatorByLockedBalanceAndOwner() {
        // write your code here
        return Comparator.comparing(BankAccount::isLocked)
                .thenComparing(BankAccount::getBalance, Comparator.reverseOrder())
                .thenComparing(BankAccount::getOwner);
    }

    public String getOwner() {
        return owner;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public String toString() {
        return owner + " " + balance + " " + locked;
    }
}



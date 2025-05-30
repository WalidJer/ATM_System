package com.keyin;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank user who can hold multiple accounts.
 */
public class User {
    private final String name;
    private final int pin;
    private final List<Account> accounts;

    /**
     * Constructs a new User.
     *
     * @param name the user's name
     * @param pin  the user's secure PIN code
     */
    public User(String name, int pin) {
        this.name = name;
        this.pin = pin;
        this.accounts = new ArrayList<>();
    }

    /**
     * Returns the user's name.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the user's PIN code.
     *
     * @return the PIN of the user
     */
    public int getPin() {
        return pin;
    }

    /**
     * Returns the list of accounts owned by the user.
     *
     * @return list of user's accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Adds a new account to the user's account list.
     *
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Finds an account by its type (e.g. "Checking" or "Savings").
     *
     * @param type the type of account
     * @return the account matching the type, or null if not found
     */
    public Account getAccountByType(String type) {
        for (Account account : accounts) {
            if (account.getAccountType().equalsIgnoreCase(type)) {
                return account;
            }
        }
        return null;
    }
}
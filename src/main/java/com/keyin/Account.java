package com.keyin;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a generic bank account.
 * Tracks balance and transaction history.
 */
public abstract class Account {
    protected double balance;
    protected List<Transaction> transactions;

    /**
     * Constructs an account with an initial balance.
     *
     * @param balance the starting balance
     */
    public Account(double balance) {
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the transaction history for the account.
     *
     * @return list of transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Attempts to withdraw a given amount and logs the transaction by default.
     *
     * @param amount the amount to withdraw
     * @return true if successful, false otherwise
     */

    public abstract Boolean withdraw(double amount);

    /**
     * Attempts to withdraw a given amount, with control over transaction logging.
     *
     * @param amount          the amount to withdraw
     * @param logTransaction  whether to record this transaction in the history
     * @return true if successful, false otherwise
     */
    public abstract Boolean withdraw(double amount, boolean logTransaction);

    /**
     * Returns the type of account (e.g., \"Checking\", \"Savings\").
     *
     * @return account type as a string
     */
    public abstract String getAccountType();

    /**
     * Deposits a positive amount into the account with optional logging.
     *
     * @param amount          the amount to deposit
     * @param logTransaction  whether to record this transaction in the history
     */
    public void deposit(double amount, boolean logTransaction) {
        if (amount > 0) {
            balance += amount;
            if (logTransaction) {
                addTransaction(TransactionType.DEPOSIT, amount);
            }
        }
    }

    /**
     * Deposits a positive amount into the account and logs the transaction by default.
     *
     * @param amount the amount to deposit
     */

    public void deposit(double amount) {
        deposit(amount, true);
    }


    /**
     * Adds a transaction record to the history.
     *
     * @param type   the type of transaction
     * @param amount the amount involved
     */
    protected void addTransaction(TransactionType type, double amount) {
        transactions.add(new Transaction(type, amount));
    }
}
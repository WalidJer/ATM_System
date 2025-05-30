package com.keyin;

/**
 * A savings account that earns interest over time.
 */
public class SavingAccount extends Account {
    private static final double INTEREST_RATE = 0.02;

    /**
     * Constructs a SavingsAccount with an initial balance.
     *
     * @param balance the starting balance
     */
    public SavingAccount(double balance) {
        super(balance);
    }

    /**
     * Attempts to withdraw a valid amount from the account.
     * Overdraft is not allowed.
     * This version allows you to control whether the transaction should be logged.
     *
     * @param amount          the amount to withdraw
     * @param logTransaction  whether to record the withdrawal in the transaction history
     * @return true if the withdrawal is successful; false otherwise
     */

    public Boolean withdraw(double amount,boolean logTransaction ) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            if (logTransaction) {
                addTransaction(TransactionType.WITHDRAW, amount);
            }
            return true;
        }
        return false;
    }

    /**
     * Withdraws the specified amount and logs the transaction by default.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is successful; false otherwise
     */
    @Override
    public Boolean withdraw(double amount) {
        return withdraw(amount, true);
    }

    /**
     * Applies interest to the current balance and records it as a transaction.
     * Interest is calculated using a fixed interest rate.
     */
    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        addTransaction(TransactionType.INTEREST, interest);
    }

    /**
     * Returns the account type.
     *
     * @return the string "Saving"
     */
    @Override
    public String getAccountType() {
        return "Saving";
    }
}
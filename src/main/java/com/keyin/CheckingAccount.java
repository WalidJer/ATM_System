package com.keyin;

/**
 * A checking account that allows overdraft up to a fixed limit.
 */
public class CheckingAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 100.0;

    /**
     * Constructs a CheckingAccount with an initial balance.
     *
     * @param balance the starting balance
     */
    public CheckingAccount(double balance) {
        super(balance);
    }

    /**
     * Attempts to withdraw a specified amount from the account.
     * Allows overdraft up to a defined limit.
     * This version allows toggling transaction logging.
     *
     * @param amount          the amount to withdraw
     * @param logTransaction  whether to record this transaction in history
     * @return true if the withdrawal is successful; false otherwise
     */
    @Override
    public Boolean withdraw(double amount, boolean logTransaction) {
        if (amount > 0 && (balance + OVERDRAFT_LIMIT >= amount)) {
            balance -= amount;
            if (logTransaction) {
                addTransaction(TransactionType.WITHDRAW, amount);
            }
            return true;
        }
        return false;
    }


    /**
     * Withdraws a specified amount and logs the transaction by default.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is successful; false otherwise
     */
    @Override
    public Boolean withdraw(double amount) {

        return withdraw(amount, true);
    }


    /**
     * Returns the account type.
     *
     * @return the string "Checking"
     */
    @Override
    public String getAccountType() {
        return "Checking";
    }
}
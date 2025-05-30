package com.keyin;


/**
 * Provides business logic for common ATM operations:
 * deposit, withdrawal, transfer, and displaying account data.
 */
public class ATMService {

    /**
     * Attempts to withdraw money from a user's account.
     *
     * @param user   the account owner
     * @param account the account to withdraw from
     * @param amount  the amount to withdraw
     * @return true if withdrawal is successful, false otherwise
     */
    public boolean withdraw(User user, Account account, double amount) {
        return account.withdraw(amount);
    }

    /**
     * Deposits money into a user's account.
     *
     * @param user   the account owner
     * @param account the account to deposit into
     * @param amount  the amount to deposit
     */
    public void deposit(User user, Account account, double amount) {

        account.deposit(amount);
    }

    /**
     * Transfers money from one user's account to another.
     *
     * @param senderUser   the sender
     * @param sender       sender's account
     * @param receiverUser the recipient
     * @param receiver     recipient's account
     * @param amount       the amount to transfer
     * @return true if transfer is successful, false otherwise
     */
    public boolean transfer(User senderUser, Account sender, User receiverUser, Account receiver, double amount) {
        if (sender.withdraw(amount,false)) {
            sender.getTransactions().add(new Transaction(TransactionType.TRANSFER_SENT, amount));
            receiver.deposit(amount, false);
            receiver.getTransactions().add(new Transaction(TransactionType.TRANSFER_RECEIVED , amount));
            return true;
        }
        return false;
    }

    /**
     * Prints account type and balance.
     *
     * @param account the account to display
     */
    public void printAccountInfo(User user, Account account) {
        System.out.printf("%s's %s Account Balance: $%.2f%n",
                user.getName(), account.getAccountType(), account.getBalance());
    }

    /**
     * Prints all transactions for a given account.
     *
     * @param account the account whose transactions will be printed
     */
    public void printTransactionHistory(Account account) {
        System.out.println("Transaction History:");
        for (Transaction transaction : account.getTransactions()) {
            System.out.println(transaction);
        }
    }
}
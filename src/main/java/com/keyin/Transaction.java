package com.keyin;


import java.time.LocalDateTime;

/**
 * Represents a financial transaction made on an account.
 * Each transaction records a type, amount, and timestamp.
 */
public class Transaction {
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime timestamp;

    /**
     * Constructs a new Transaction with the specified type and amount.
     * Automatically timestamps the transaction.
     *
     * @param type   the type of transaction
     * @param amount the transaction amount
     */
    public Transaction(TransactionType type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Returns a formatted string for displaying transaction details.
     *
     * @return a string representation of the transaction in the format: timestamp | type: $amount
     */
    @Override
    public String toString() {
        return String.format("%s | %s: $%.2f", timestamp, type, amount);
    }
}
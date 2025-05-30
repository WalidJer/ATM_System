package com.keyin;

public class Main {

    public static void main(String[] args) {
        // Create users and accounts
        User walid = new User("Walid", 1111);
        SavingAccount walidSavings = new SavingAccount(1000.00);
        CheckingAccount walidChecking = new CheckingAccount(500.00);

        walid.addAccount(walidChecking);
        walid.addAccount(walidSavings);

        User john = new User("John", 2222);
        CheckingAccount johnChecking = new CheckingAccount(300.00);
        john.addAccount(johnChecking);

        ATMService atmService = new ATMService();

        // Initial Balances
        System.out.println("\n======  Initial Account Balances  ======");
        atmService.printAccountInfo(walid, walidChecking);
        atmService.printAccountInfo(walid, walidSavings);
        atmService.printAccountInfo(john, johnChecking);

        // Transactions

        atmService.deposit(walid, walidChecking, 200.00);
        atmService.withdraw(walid, walidChecking, 100.00);

        atmService.deposit(walid, walidSavings, 300.00);
        atmService.withdraw(walid, walidSavings, 50.00);

        double preInterest = walidSavings.getBalance();
        double interest = preInterest * 0.02;
        walidSavings.applyInterest();

        atmService.transfer(walid, walidChecking, john, johnChecking, 150.00);
        atmService.transfer(walid, walidSavings, john, johnChecking, 100.00);

        // Walid Account Info
        System.out.println("\n======  Walid's Checking Account Info ======");
        System.out.println("[Account Type: Checking]");
        atmService.printTransactionHistory(walidChecking);
        atmService.printAccountInfo(walid, walidChecking);

        System.out.println("\n======  Walid's Savings Account Info ======");
        System.out.println("[Account Type: Savings]");
        atmService.printTransactionHistory(walidSavings);
        atmService.printAccountInfo(walid, walidSavings);
        System.out.printf("\n Interest applied: %.2f * 0.02 = %.2f%n", preInterest, interest);

        // John's Account Info
        System.out.println("\n======  John's Checking Account Info ======");
        System.out.println("[Account Type: Checking]");
        atmService.printTransactionHistory(johnChecking);
        atmService.printAccountInfo(john, johnChecking);

        // Summary Report
        double walidTotal = walidChecking.getBalance() + walidSavings.getBalance();
        double johnTotal = johnChecking.getBalance();

        System.out.println("\n======  Summary Balance Report  ======");
        System.out.printf("Walid's Total Balance: $%.2f%n", walidTotal);
        System.out.printf("  ├── Checking: $%.2f%n", walidChecking.getBalance());
        System.out.printf("  └── Savings : $%.2f%n", walidSavings.getBalance());

        System.out.printf("\nJohn's Total Balance:   $%.2f%n", johnTotal);
        System.out.printf("  └── Checking: $%.2f%n", johnTotal);
    }
}

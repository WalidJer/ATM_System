package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ATMServiceTest {
    private ATMService atmService;
    private User walid, john;
    private CheckingAccount walidChecking, johnChecking;
    private SavingAccount walidSavings;


    @BeforeEach
    public void setup() {
        atmService = new ATMService();

        walid = new User("Walid", 1111);
        john = new User("John", 2222);

        walidChecking = new CheckingAccount(500.00);
        walidSavings = new SavingAccount(1000.00);
        johnChecking = new CheckingAccount(300.00);

        walid.addAccount(walidChecking);
        walid.addAccount(walidSavings);
        john.addAccount(johnChecking);
    }

    @Test
    public void testDeposit() {
        atmService.deposit(walid, walidChecking, 200.00);
        Assertions.assertEquals(700.00, walidChecking.getBalance(), 0.001);
    }


    @Test
    public void testNegativeDeposit() {
        atmService.deposit(walid, walidChecking, -100.00);
        Assertions.assertEquals(500.00, walidChecking.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        boolean result = atmService.withdraw(walid, walidChecking, 100.00);
        Assertions.assertTrue(result);
        Assertions.assertEquals(400.00, walidChecking.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawOverLimit() {
        boolean result = atmService.withdraw(walid, walidChecking, 700.00);
        Assertions.assertFalse(result);
        Assertions.assertEquals(500.00, walidChecking.getBalance(), 0.001);
    }


    @Test
    public void testZeroWithdraw() {
        boolean result = atmService.withdraw(walid, walidChecking, 0.00);
        Assertions.assertFalse(result);
        Assertions.assertEquals(500.00, walidChecking.getBalance(), 0.001);
    }

    @Test
    public void testTransferBetweenOwnAccounts() {
        boolean result = atmService.transfer(walid, walidChecking, walid, walidSavings, 100.00);
        Assertions.assertTrue(result);
        Assertions.assertEquals(400.00, walidChecking.getBalance(), 0.001);
        Assertions.assertEquals(1100.00, walidSavings.getBalance(), 0.001);
    }


    @Test
    public void testTransferBetweenUsers() {
        boolean result = atmService.transfer(walid, walidChecking, john, johnChecking, 100.00);
        Assertions.assertTrue(result);
        Assertions.assertEquals(400.00, walidChecking.getBalance(), 0.001);
        Assertions.assertEquals(400.00, johnChecking.getBalance(), 0.001);
    }


    @Test
    public void testApplyInterestToSavings() {
        double expectedInterest = 1000.00 * 0.02;
        walidSavings.applyInterest();
        Assertions.assertEquals(1000.00 + expectedInterest, walidSavings.getBalance(), 0.001);
    }


}

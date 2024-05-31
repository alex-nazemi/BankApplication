package com.example.bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;


public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        Assert.assertEquals(1000, bankAccount.balance);
    }

    @Test
    public void testWithdraw() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));
        Assert.assertEquals(-500, bankAccount.balance);
    }

    @Test
    public void testGenerateStatement() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 13));
        bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));

        String stringExpected = """
            date || credit || debit || balance
            14/01/2021 || - || 500.00 || 2500.00
            13/01/2021 || 2000.00 || - || 3000.00
            10/01/2021 || 1000.00 || - || 1000.00
            """;
        stringExpected = stringExpected.trim();
        Assert.assertEquals(stringExpected, bankAccount.generateStatement().trim());
    }




}

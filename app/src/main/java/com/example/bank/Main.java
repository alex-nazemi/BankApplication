
package com.example.bank;

import java.time.LocalDate;

// create Bank Class
// deposit method, takes two args, int and LocalDate object
// withdraw method, takes two args, int and LocalDate object
// generate statement, prints formatted bank statement

// need to write tests first for each method

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        // Given a client makes a deposit of 1000 on 2021-01-10
        bankAccount.deposit(1000, LocalDate.of(2021, 1, 10));

        // And a deposit of 2000 on 2021-01-13
        bankAccount.deposit(2000, LocalDate.of(2021, 1, 13));

        // And a withdrawal of 500 on 2021-01-14
        //bankAccount.withdraw(500, LocalDate.of(2021, 1, 14));

        // When she prints her bank statement
        //System.out.println(bankAccount.generateStatement());
    }
}

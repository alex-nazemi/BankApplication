package com.example.bank;

import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {

    int balance;
    ArrayList<String> accountHistory = new ArrayList<>();

    public BankAccount() {
        this.balance = 0;
    }

    public void deposit(Integer amount, LocalDate timestamp) {
        balance += amount;
        accountHistory.add(String.format("%d/%d/%d || %.2f || - || %.2f", timestamp.getDayOfMonth(), timestamp.getMonthValue(), timestamp.getYear(), (double) amount, (double) balance));
    }

    public void withdraw(Integer amount, LocalDate timestamp) {
        balance -= amount;
        accountHistory.add(String.format("%d/%d/%d || - || %.2f || %.2f", timestamp.getDayOfMonth(), timestamp.getMonthValue(), timestamp.getYear(), (double) amount, (double) balance));
    }

    public String generateStatement() {
        StringBuilder fullAccountHistory = new StringBuilder();

        fullAccountHistory.append("date || credit || debit || balance\n");

        for (int i = accountHistory.size() - 1; i >= 0; i--) {
            String[] parts = accountHistory.get(i).split(" \\|\\| ");

            String[] dateParts = parts[0].split("/");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            String formattedDate = String.format("%02d/%02d/%d", day, month, year);

            String formattedEntry = String.format("%s || %s || %s || %s",
                    formattedDate, parts[1], parts[2], parts[3]);

            fullAccountHistory.append(formattedEntry).append("\n");
        }

        return fullAccountHistory.toString();
    }




}

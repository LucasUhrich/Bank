package com.project.bank.Utils;

public class AccountNumberGenerator {

    public static String accountNumberGenerator() {
        int length = 10;
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int digit = (int) (Math.random() * 10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }

}

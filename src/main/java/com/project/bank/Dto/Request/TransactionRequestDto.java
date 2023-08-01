package com.project.bank.Dto.Request;

import com.project.bank.Enum.AccountType;

import java.io.Serializable;
public class TransactionRequestDto implements Serializable {
    private double balance;
    private String sender_account;
    private String receive_account;

    private AccountType account_type;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(double balance, String sender_account, String receive_account, AccountType account_type) {
        this.balance = balance;
        this.sender_account = sender_account;
        this.receive_account = receive_account;
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getSender_account() {
        return sender_account;
    }

    public void setSender_account(String sender_account) {
        this.sender_account = sender_account;
    }

    public String getReceive_account() {
        return receive_account;
    }

    public void setReceive_account(String receive_account) {
        this.receive_account = receive_account;
    }

    public AccountType getAccount_type() {
        return account_type;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }
}
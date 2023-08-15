package com.project.bank.Dto.Response;

import java.io.Serializable;

public class TransactionResponseDto implements Serializable {
    private String id;
    private double balance;
    private String sender_account;
    private String receive_account;
    private BankResponseDto bank;
    private BranchResponseDto branch;

    public TransactionResponseDto() {
    }

    public TransactionResponseDto(String id, double balance, String sender_account, String receive_account, BankResponseDto bank, BranchResponseDto branch) {
        this.id = id;
        this.balance = balance;
        this.sender_account = sender_account;
        this.receive_account = receive_account;
        this.bank = bank;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public BankResponseDto getBank() {
        return bank;
    }

    public void setBank(BankResponseDto bank) {
        this.bank = bank;
    }

    public BranchResponseDto getBranch() {
        return branch;
    }

    public void setBranch(BranchResponseDto branch) {
        this.branch = branch;
    }
}
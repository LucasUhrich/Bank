package com.project.bank.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private double balance;

    private String sender_account;

    private String receive_account;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

}

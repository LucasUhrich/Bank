package com.project.bank.Dao.Request;

import java.io.Serializable;

public class BankRequestDto implements Serializable {
    private final String name;

    public BankRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
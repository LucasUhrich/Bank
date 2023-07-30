package com.project.bank.Dao.Response;

import java.io.Serializable;

public class BankResponseDto implements Serializable {
    private final String id;
    private final String name;

    public BankResponseDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
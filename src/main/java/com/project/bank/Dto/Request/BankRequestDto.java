package com.project.bank.Dto.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class BankRequestDto implements Serializable {
    @NotBlank(message = "Name cannot be null")
    @Size(min = 3, message = "Invalid name, minimum 3 characters")
    private String name;

    public BankRequestDto(String name) {
        this.name = name;
    }

    public BankRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
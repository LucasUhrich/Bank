package com.project.bank.Dto.Request;

import com.project.bank.Enum.AccountType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


public class OperationRequestDto implements Serializable {
    @NotBlank(message = "Mount cannot be null")
    private double mount;
    @NotBlank(message = "Account number cannot be null")
    @Size(max = 10, message = "Invalid account number, minium 10 characters")
    private String account;
    @NotBlank(message = "Account type cannot be null")
    private AccountType account_type;

    public OperationRequestDto() {
    }

    public OperationRequestDto(double mount, String account, AccountType account_type) {
        this.mount = mount;
        this.account = account;
        this.account_type = account_type;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public AccountType getAccount_type() {
        return account_type;
    }

    public void setAccount_type(AccountType account_type) {
        this.account_type = account_type;
    }
}
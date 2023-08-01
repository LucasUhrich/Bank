package com.project.bank.Dto.Response;

import com.project.bank.Enum.OperationType;

import java.io.Serializable;

public class OperationResponseDto implements Serializable {
    private String id;
    private OperationType operation_type;
    private double mount;
    private String account;

    public OperationResponseDto() {
    }

    public OperationResponseDto(String id, OperationType operation_type, double mount, String account) {
        this.id = id;
        this.operation_type = operation_type;
        this.mount = mount;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OperationType getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(OperationType operation_type) {
        this.operation_type = operation_type;
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
}
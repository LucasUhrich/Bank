package com.project.bank.Dao.Response;

import com.project.bank.Entity.Bank;

import java.io.Serializable;

public class BranchResponseDto implements Serializable {
    private  String id;
    private  String country;
    private  String province;
    private  String city;
    private  BankResponseDto bankResponseDto;

    public BranchResponseDto() {
    }

    public BranchResponseDto(String id, String country, String province, String city, BankResponseDto bankResponseDto) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.bankResponseDto = bankResponseDto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BankResponseDto getBankResponseDto() {
        return bankResponseDto;
    }

    public void setBankResponseDto(BankResponseDto bankResponseDto) {
        this.bankResponseDto = bankResponseDto;
    }
}
package com.project.bank.Dao.Request;

import java.io.Serializable;

public class BranchRequestDto implements Serializable {
    private String country;
    private String province;
    private String city;

    public BranchRequestDto(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public BranchRequestDto() {
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
}
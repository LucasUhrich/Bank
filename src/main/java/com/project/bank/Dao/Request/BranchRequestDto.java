package com.project.bank.Dao.Request;

import java.io.Serializable;

public class BranchRequestDto implements Serializable {
    private final String country;
    private final String province;
    private final String city;

    public BranchRequestDto(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}
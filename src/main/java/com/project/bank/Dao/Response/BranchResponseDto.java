package com.project.bank.Dao.Response;

import java.io.Serializable;

public class BranchResponseDto implements Serializable {
    private final String id;
    private final String country;
    private final String province;
    private final String city;

    public BranchResponseDto(String id, String country, String province, String city) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getId() {
        return id;
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
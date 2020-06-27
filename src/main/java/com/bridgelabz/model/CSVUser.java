package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByPosition;

public class CSVUser {

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String email;

    @CsvBindByPosition(position = 2)
    private String phoneNum;

    @CsvBindByPosition(position = 3)
    private String country;

    public CSVUser() {
    }

    public CSVUser(String name, String email, String phoneNum, String country) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return name + "," + email + "," + phoneNum + "," + country;
    }
}

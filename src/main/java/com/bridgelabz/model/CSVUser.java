package com.bridgelabz.model;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {

    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNum;

    @CsvBindByName
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

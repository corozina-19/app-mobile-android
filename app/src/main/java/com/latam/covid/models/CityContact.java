package com.latam.covid.models;

public class CityContact {
    private String city;
    private String phoneNumber;
    private String description;

    public CityContact(String city, String phoneNumber, String description){
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }
    public CityContact(){

    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


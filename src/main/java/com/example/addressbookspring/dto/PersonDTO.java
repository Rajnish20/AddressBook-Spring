package com.example.addressbookspring.dto;

public class PersonDTO {
    private String name;
    private String city;

    public PersonDTO(String name, String  city){
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

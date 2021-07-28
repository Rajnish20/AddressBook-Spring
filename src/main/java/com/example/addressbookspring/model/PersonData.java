package com.example.addressbookspring.model;

import com.example.addressbookspring.dto.PersonDTO;

public class PersonData {
    private int personId;
    private String name;
    private String city;

    public PersonData(){

    }

    public PersonData(int personId, PersonDTO personDTO){
        this.personId = personId;
        this.name = personDTO.getName();
        this.city = personDTO.getCity();
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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
}

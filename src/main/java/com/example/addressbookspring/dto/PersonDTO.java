package com.example.addressbookspring.dto;

import lombok.Data;

public @Data
class PersonDTO {
    private String name;
    private String city;

    public PersonDTO(String name, String  city){
        this.name = name;
        this.city = city;
    }

}

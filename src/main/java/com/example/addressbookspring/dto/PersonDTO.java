package com.example.addressbookspring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data
class PersonDTO {
    @NotEmpty(message = "Person name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Person Name Invalid")
    private String name;

    @NotEmpty(message = "City field cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Invalid City")
    private String city;

    public PersonDTO(String name, String  city){
        this.name = name;
        this.city = city;
    }

}

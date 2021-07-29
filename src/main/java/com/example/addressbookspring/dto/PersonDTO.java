package com.example.addressbookspring.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * Represents Person DTO
 * @author Rajnish Sahu
 */
public @Data
class PersonDTO {
    @NotEmpty(message = "Person name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Person Name Invalid")
    private String name;

    @Pattern(regexp = "\\d{2}\\d{10}",message = "Invalid Phone Number")
    private String phoneNumber;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "City field cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Invalid City")
    private String city;

    @NotEmpty(message = "State field cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Invalid State")
    private String state;

    @NotEmpty(message = "PinCode cannot be empty")
    private String pinCode;
}

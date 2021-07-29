package com.example.addressbookspring.model;

import com.example.addressbookspring.dto.PersonDTO;
import lombok.Data;

import javax.persistence.*;

/** Represents a person.
 * @author Rajnish Sahu
 */
@Entity
@Table(name = "address_book")
public @Data class PersonData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int personId;
    private String name;
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String state;
    private String address;
    @Column(name = "pin_code")
    private String pinCode;

    /**
     * Creates a Person
     */
    public PersonData(){

    }

    /**
     * Creates a Person with specified Person DTO
     * @param personDTO passed in Request Body
     */
    public PersonData(PersonDTO personDTO){
        this.updatePersonData(personDTO);

    }

    /**
     * Update Person Data with specified Person DTO
     * @param personDTO
     */
    public void updatePersonData(PersonDTO personDTO){
        this.name = personDTO.getName();
        this.phoneNumber = personDTO.getPhoneNumber();
        this.address = personDTO.getAddress();
        this.city = personDTO.getCity();
        this.state = personDTO.getState();
        this.pinCode = personDTO.getPinCode();
    }

}

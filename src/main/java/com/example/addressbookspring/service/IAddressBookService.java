package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.model.PersonData;

import java.util.List;

public interface IAddressBookService {
    List<PersonData> getPersonData();

    PersonData getPersonById(int personId);

    PersonData createPerson(PersonDTO personDTO);

    PersonData updatePersonData(PersonDTO personDTO, int personId);

    void deletePerson(int personId);
}

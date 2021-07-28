package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.model.PersonData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{
    @Override
    public List<PersonData> getPersonData() {
        List<PersonData> personDataList = new ArrayList<>();
        personDataList.add(new PersonData(1,new PersonDTO("Sneha","New Delhi")));
        return personDataList;
    }

    @Override
    public PersonData getPersonById(int personId) {
        PersonData personData =new PersonData(personId,new PersonDTO("Kajal","New Delhi"));
        return personData;
    }

    @Override
    public PersonData createPerson(PersonDTO personDTO) {
        PersonData personData = new PersonData(1,personDTO);
        return personData;
    }

    @Override
    public PersonData updatePersonData(PersonDTO personDTO, int personId) {
        PersonData personData = new PersonData(personId, personDTO);
        return personData;
    }

    @Override
    public void deletePerson(int personId) {
    }
}

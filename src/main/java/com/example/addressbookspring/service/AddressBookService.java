package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.model.PersonData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService{

    private List<PersonData> personDataList = new ArrayList<>();
    @Override
    public List<PersonData> getPersonData() {
        return personDataList;
    }

    @Override
    public PersonData getPersonById(int personId) {
        return this.personDataList.get(personId - 1);
    }

    @Override
    public PersonData createPerson(PersonDTO personDTO) {
        PersonData personData = new PersonData(1,personDTO);
        this.personDataList.add(personData);
        return personData;
    }

    @Override
    public PersonData updatePersonData(PersonDTO personDTO, int personId) {
        PersonData personData = this.getPersonById(personId);
        personData.setName(personDTO.getName());
        personData.setCity(personDTO.getCity());
        personDataList.set(personId - 1, personData);
        return personData;
    }

    @Override
    public void deletePerson(int personId) {
        personDataList.remove(personId - 1);
    }
}

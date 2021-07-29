package com.example.addressbookspring.service;

import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.exception.AddressBookException;
import com.example.addressbookspring.model.PersonData;
import com.example.addressbookspring.repository.IAddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Represents Address Book CRUD operations
 * @author Rajnish Sahu
 */
@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private IAddressBookRepository addressBookRepository;

    /**
     * @return list of all the person stored in addressBookRepository
     */
    @Override
    public List<PersonData> getPersonData() {
        return addressBookRepository.findAll();
    }

    /**
     * Finds person data using person Id
     * @param personId
     * @return object of PersonData type
     */
    @Override
    public PersonData getPersonById(int personId) {
        return this.addressBookRepository
                .findById(personId)
                .orElseThrow(() -> new AddressBookException("Person Not Found"));
    }

    /**
     * Creates a object of PersonData type and store it in addressBookRepository
     * @param personDTO
     * @return created object of PersonData type
     */
    @Override
    public PersonData createPerson(PersonDTO personDTO) {
        PersonData personData = new PersonData(personDTO);
        return addressBookRepository.save(personData);
    }

    /**
     * Update PersonData with the specified PersonDTO and save it to addressBookRepository
     * @param personDTO
     * @param personId
     * @return updated object of PersonData type
     */
    @Override
    public PersonData updatePersonData(PersonDTO personDTO, int personId) {
        PersonData personData = this.getPersonById(personId);
        personData.updatePersonData(personDTO);
        return addressBookRepository.save(personData);
    }

    /**
     * Deletes PersonData object from addressBookRepository
     * @param personId
     */
    @Override
    public void deletePerson(int personId) {
        PersonData personData = this.getPersonById(personId);
        addressBookRepository.delete(personData);
    }
}

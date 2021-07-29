package com.example.addressbookspring.controller;

import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.dto.ResponseDTO;
import com.example.addressbookspring.model.PersonData;
import com.example.addressbookspring.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Represent AddressBook REST API Controller
 * @author Rajnish Sahu
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * calls the getPersonData method of addressBookService class
     * @return ResponseEntity of ResponseDTO type with the appropriate HTTP Status code
     */
    @GetMapping(value = {"","/","home"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        List<PersonData> personDataList = addressBookService.getPersonData();
        ResponseDTO responseDTO = new ResponseDTO("Get call successful",personDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * calls the getPersonById method of addressBookService class
     * @param personId passed as a Path Variable by the user
     * @return ResponseEntity of ResponseDTO type with the appropriate HTTP Status code
     */
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable int personId){
        PersonData personData = addressBookService.getPersonById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get call successful",personData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * calls the createPerson method of addressBookService class
     * @param personDTO passed as Request Body by the user
     * @return ResponseEntity of ResponseDTO type with the appropriate HTTP Status code
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@Valid @RequestBody PersonDTO personDTO){
        PersonData personData = addressBookService.createPerson(personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Person Successfully",personData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * calls the updatePersonData method of addressBookService class
     * @param personDTO passed as Request Body by the user
     * @param personId passed as Path Variable by the user
     * @return ResponseEntity of ResponseDTO type with the appropriate HTTP Status code
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@Valid @RequestBody  PersonDTO personDTO, @PathVariable int personId){
        PersonData personData = addressBookService.updatePersonData(personDTO,personId);
        ResponseDTO responseDTO = new ResponseDTO("Updated Person Data Successfully",personData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    /**
     * calls the deletePerson method of addressBookService class
     * @param id passed as a Path Variable by the user
     * @return ResponseEntity of ResponseDTO type with the appropriate HTTP Status code
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById(@PathVariable int id){
        addressBookService.deletePerson(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Successful ",+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}

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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping(value = {"","/","home"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        List<PersonData> personDataList = addressBookService.getPersonData();
        ResponseDTO responseDTO = new ResponseDTO("Get call successful",personDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable int personId){
        PersonData personData = addressBookService.getPersonById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get call successful",personData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@Valid @RequestBody PersonDTO personDTO){
        PersonData personData = addressBookService.createPerson(personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Person Successfully",personData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@Valid @RequestBody  PersonDTO personDTO, @PathVariable int personId){
        PersonData personData = addressBookService.updatePersonData(personDTO,personId);
        ResponseDTO responseDTO = new ResponseDTO("Updated Person Data Successfully",personData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById(@PathVariable int id){
        addressBookService.deletePerson(id);
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Successful ",+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}

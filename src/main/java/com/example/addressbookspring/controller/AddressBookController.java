package com.example.addressbookspring.controller;

import com.example.addressbookspring.dto.PersonDTO;
import com.example.addressbookspring.dto.ResponseDTO;
import com.example.addressbookspring.model.PersonData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping(value = {"","/","home"})
    public ResponseEntity<ResponseDTO> getEmployeePayroll(){
        PersonData personData = new PersonData(1,new PersonDTO("Shatakashi","Noida"));
        ResponseDTO responseDTO = new ResponseDTO("Get call successful",personData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollById(@PathVariable int id){
        PersonData personData = new PersonData(1,new PersonDTO("Shatakashi","Noida"));
        ResponseDTO responseDTO = new ResponseDTO("Get call successful",personData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayroll(@RequestBody PersonDTO personDTO){
        PersonData personData = new PersonData(1,personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Person Successfully",personData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayroll(@RequestBody  PersonDTO personDTO){
        PersonData personData = new PersonData(1,personDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Person Data Successfully",personData);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Delete Call Successful ",+id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}

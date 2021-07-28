package com.example.addressbookspring.controller;

import com.example.addressbookspring.dto.PersonDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping(value = {"","/","home"})
    public String getEmployeePayroll(){
        return "Got Person Data successfully ";
    }

    @GetMapping("/get/{id}")
    public String getEmployeePayrollById(@PathVariable int id){
        return "Got Person Data with Id: "+id +" successfully";
    }

    @PostMapping("/create")
    public String addEmployeePayroll(@RequestBody PersonDTO personDTO){
        return "Person Created Successfully "+personDTO;
    }

    @PutMapping("/update")
    public String updateEmployeePayroll(@RequestBody  PersonDTO personDTO){
        return "Person Updated Successfully "+personDTO;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeePayrollById(@PathVariable int id){
        return "Person with id "+id+" deleted successfully";
    }
}

package com.example.addressbookspring.repository;

import com.example.addressbookspring.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressBookRepository extends JpaRepository<PersonData,Integer> {
}

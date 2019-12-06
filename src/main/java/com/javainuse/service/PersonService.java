package com.javainuse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javainuse.model.Address;
import com.javainuse.model.Person;
import com.javainuse.repo.PersonRepository;

@Component
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getPersons() {
		return (List<Person>) personRepository.findAll();
	}

	public Iterable<Person> getPersonByAddress(Address address) {
		List<Address> list = new ArrayList<Address>();
		list.add(address);
		return personRepository.findAllById(list);
	}

}

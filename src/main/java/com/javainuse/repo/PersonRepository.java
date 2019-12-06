package com.javainuse.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javainuse.model.Address;
import com.javainuse.model.Person;

@Repository
public interface PersonRepository extends  CrudRepository<Person,Address>{

}

package com.app.personae.feature.person.services;

import com.app.personae.feature.person.dtos.SearchDTO;
import com.app.personae.feature.person.entities.Person;
import com.app.personae.feature.person.repositories.PersonRepository;
import com.app.personae.feature.person.specification.PersonSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<Person> search(SearchDTO criteria, Pageable pageable){
        return personRepository.findAll(PersonSpecification.findByCriteria(criteria), pageable);
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}

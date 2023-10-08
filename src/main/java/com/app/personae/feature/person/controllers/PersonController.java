package com.app.personae.feature.person.controllers;

import com.app.personae.feature.person.dtos.SearchDTO;
import com.app.personae.feature.person.entities.Employee;
import com.app.personae.feature.person.entities.Person;
import com.app.personae.feature.person.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/search")
    public Page<Person> search(@RequestBody SearchDTO criteria, Pageable pageable)  {
        return personService.search(criteria, pageable);
    }
}

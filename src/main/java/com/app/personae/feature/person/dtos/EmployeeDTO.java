package com.app.personae.feature.person.dtos;

import com.app.personae.feature.person.enums.Gender;
import com.app.personae.feature.person.enums.PersonType;

import java.util.Date;
import java.util.UUID;

public record EmployeeDTO(
        UUID id,
        String name,
        Gender gender,
        PersonType personType,
        String surname,
        String pesel,
        double height,
        double weight,
        String email,
        Date employmentStartDate,
        String position,
        double salary) {}

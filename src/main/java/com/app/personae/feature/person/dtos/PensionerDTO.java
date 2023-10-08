package com.app.personae.feature.person.dtos;

import com.app.personae.feature.person.enums.Gender;
import com.app.personae.feature.person.enums.PersonType;

import java.util.UUID;

public record PensionerDTO(
        UUID id,
        Gender gender,
        PersonType personType,
        String name,
        String surname,
        String pesel,
        double height,
        double weight,
        String email,
        double pension,
        int yearsWorked) {}

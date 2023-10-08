package com.app.personae.feature.person.dtos;

import com.app.personae.feature.person.enums.Gender;
import com.app.personae.feature.person.enums.PersonType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SearchDTO {

    // All
    private Gender gender;
    private PersonType personType;
    private String name;
    private String surname;
    private String pesel;
    private String email;
    private Integer ageFrom;
    private Integer ageTo;
    private Double heightFrom;
    private Double heightTo;
    private Double weightFrom;
    private Double weightTo;

    // Employees only
    private Date employmentStartDateFrom;
    private Date employmentStartDateTo;
    private Double salaryFrom;
    private Double salaryTo;
    private String position;

    // Students only
    private String universityName;
    private Integer yearOfStudyFrom;
    private Integer yearOfStudyTo;
    private String major;
    private Double scholarshipFrom;
    private Double scholarshipTo;

    // Pensioners only
    private Double pensionFrom;
    private Double pensionTo;
    private Integer yearsWorkedFrom;
    private Integer yearsWorkedTo;

}

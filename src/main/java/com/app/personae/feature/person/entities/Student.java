package com.app.personae.feature.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends Person{

    @Column(name = "university_Name")
    private String universityName;

    @Column(name = "year_Of_Study")
    private int yearOfStudy;

    @Column(name = "major")
    private String major;

    @Column(name = "scholarship")
    private double scholarship;


}

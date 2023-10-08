package com.app.personae.feature.person.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends Person{

    @Temporal(TemporalType.DATE)
    @Column(name = "employmentStartDate")
    private Date employmentStartDate;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

}

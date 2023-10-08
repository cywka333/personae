package com.app.personae.feature.person.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity(name = "pensioner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pensioner extends Person{

    @Column(name = "pension")
    private double pension;

    @Column(name = "yearsWorked")
    private int yearsWorked;
}

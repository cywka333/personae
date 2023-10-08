package com.app.personae.feature.person.specification;

import com.app.personae.feature.person.dtos.SearchDTO;
import com.app.personae.feature.person.entities.Employee;
import com.app.personae.feature.person.entities.Pensioner;
import com.app.personae.feature.person.entities.Person;
import com.app.personae.feature.person.entities.Student;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonSpecification {
    public static Specification<Person> findByCriteria(SearchDTO criteria){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            //Common criteria
            if(criteria.getGender() != null){
                predicates.add(criteriaBuilder.equal(root.get("gender"), criteria.getGender().toString()));
            }
            if(criteria.getPersonType() != null){
                predicates.add(criteriaBuilder.equal(root.get("personType"), criteria.getPersonType().toString()));
            }
            if(criteria.getName() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + criteria.getName().toLowerCase() + "%"));
            }
            if(criteria.getSurname() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("surname")), "%" + criteria.getSurname().toLowerCase() + "%"));
            }
            if(criteria.getPesel() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("pesel")), "%" + criteria.getPesel().toLowerCase() + "%"));
            }
            if(criteria.getEmail() != null){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + criteria.getEmail().toLowerCase() + "%"));
            }
            if(criteria.getHeightFrom() != null && criteria.getHeightTo() != null){
                predicates.add(criteriaBuilder.between(root.get("height"), criteria.getHeightFrom(), criteria.getHeightTo()));
            }
            if(criteria.getWeightFrom() != null && criteria.getWeightTo() != null){
                predicates.add(criteriaBuilder.between(root.get("weight"), criteria.getWeightFrom(), criteria.getWeightTo()));
            }

            // Type-specific criteria
            if(criteria.getPersonType() != null){
                if("employee".equalsIgnoreCase(criteria.getPersonType().toString())){
                    root.as(Employee.class);
                    if (criteria.getPosition() != null) {
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("position")), "%" + criteria.getPosition().toLowerCase() + "%"));
                    }
                    if (criteria.getEmploymentStartDateFrom() != null && criteria.getEmploymentStartDateTo() != null){
                        predicates.add(criteriaBuilder.between(root.get("employmentStartDate"), criteria.getEmploymentStartDateFrom(), criteria.getEmploymentStartDateTo()));
                    }
                    if (criteria.getSalaryFrom() != null && criteria.getSalaryTo() != null){
                        predicates.add(criteriaBuilder.between(root.get("salary"), criteria.getSalaryFrom(), criteria.getSalaryTo()));
                    }
                } else if ("student".equalsIgnoreCase(criteria.getPersonType().toString())) {
                    root.as(Student.class);
                    if (criteria.getUniversityName() != null){
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("universityName")), "%" + criteria.getUniversityName().toLowerCase() + "%"));
                    }
                    if (criteria.getYearOfStudyFrom() != null && criteria.getYearOfStudyTo() != null){
                        predicates.add(criteriaBuilder.between(root.get("yearOfStudy"), criteria.getYearOfStudyFrom(), criteria.getYearOfStudyTo()));
                    }
                    if (criteria.getMajor() != null){
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("major")), "%" + criteria.getMajor().toLowerCase() + "%"));
                    }
                    if (criteria.getScholarshipFrom() != null && criteria.getScholarshipTo() != null){
                        predicates.add(criteriaBuilder.between(root.get("scholarship"), criteria.getScholarshipFrom(), criteria.getScholarshipTo()));
                    }
                } else if ("pensioner".equalsIgnoreCase(criteria.getPersonType().toString())) {
                    root.as(Pensioner.class);
                    if (criteria.getPensionFrom() != null && criteria.getPensionTo() != null){
                        predicates.add(criteriaBuilder.between(root.get("pension"), criteria.getPensionFrom(), criteria.getPensionTo()));
                    }
                    if (criteria.getYearsWorkedFrom() != null && criteria.getYearsWorkedTo() != null){
                        predicates.add(criteriaBuilder.between(root.get("yearsWorked"), criteria.getYearsWorkedFrom(), criteria.getYearsWorkedTo()));
                    }
                }
            }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}

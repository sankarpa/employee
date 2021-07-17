package com.example.employee.models;

import com.example.employee.validator.EmployeeAge;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_id_seq", allocationSize = 1)
    private Integer id;

    @NotNull
    @NotBlank
    private String name;

    @EmployeeAge
    @NotNull(message = "Provide date of birth")
    private Date dateOfBirth;

    private String gender;

    private Double salary;

    private String department;


}

package com.example.employee.controller;

import com.example.employee.models.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee){
        employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


//    Get API to list all employees
//    Put API to update an employee
//    Delete API to delete an employee

}

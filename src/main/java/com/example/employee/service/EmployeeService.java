package com.example.employee.service;

import com.example.employee.models.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class EmployeeService {


    @Autowired
    EntityManager entityManager;


    @Autowired
    EmployeeRepository employeeRepository;


    @Transactional
    public Employee createEmployee(Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return savedEmployee;
    }

}

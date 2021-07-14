package com.example.employee.repository;

import com.example.employee.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

//    Service - Functionality of a business logic which provides data or process the data that could be used by a controller or  a client
//    Repository - Interface through which we access persistent data
//            CRUD = CREATE READ UPDATE DELETE
//    Configuration - feeds the properties that can be used by service or repository to make the application dynamic or loosely coupled.

}

package com.example.employee.repository;

import com.example.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

//    Service - Functionality of a business logic which provides data or process the data that could be used by a controller or  a client
//    Repository - Interface through which we access persistent data
//            CRUD = CREATE READ UPDATE DELETE
//    Configuration - feeds the properties that can be used by service or repository to make the application dynamic or loosely coupled.

}

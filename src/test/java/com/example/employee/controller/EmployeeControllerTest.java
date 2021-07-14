package com.example.employee.controller;

import com.example.employee.models.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = EmployeeController.class
)
class EmployeeControllerTest {

        @MockBean
        EmployeeService employeeService;

        @Autowired
        MockMvc mockMvc;

        @Test
        void testShouldCallPostOfEmployeeAndCreateEmployeeInDataBase() throws Exception {
                HashMap<String,String> requestBody = new HashMap<>();
                requestBody.put("name", "test_name");

                ObjectMapper objectMapper = new ObjectMapper();

                mockMvc.perform(post("/employee")
                        .content(objectMapper.writeValueAsString(requestBody))
                        .contentType("application/json")
                        )
                    .andExpect(status().isCreated());
        }


}

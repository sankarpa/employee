package com.example.employee.controller;

import com.example.employee.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                requestBody.put("dateOfBirth", "1990-10-10");

                ObjectMapper objectMapper = new ObjectMapper();

                mockMvc.perform(post("/employee")
                        .content(objectMapper.writeValueAsString(requestBody))
                        .contentType("application/json")
                        )
                    .andExpect(status().isCreated());
        }


        @Test
        void testShouldCallPostOfEmployeeAndReturnBAdRequestIfNameIsMissing() throws Exception {
                HashMap<String,String> requestBody = new HashMap<>();

                ObjectMapper objectMapper = new ObjectMapper();

                mockMvc.perform(post("/employee")
                        .content(objectMapper.writeValueAsString(requestBody))
                        .contentType("application/json")
                )
                        .andExpect(status().isBadRequest());
        }

        @Test
        void testShouldCallPostOfEmployeeAndReturnBAdRequestIfDateOfBirthIsMissing() throws Exception {
                HashMap<String,String> requestBody = new HashMap<>();
                requestBody.put("name", "test_name");

                ObjectMapper objectMapper = new ObjectMapper();

                mockMvc.perform(post("/employee")
                        .content(objectMapper.writeValueAsString(requestBody))
                        .contentType("application/json")
                )
                        .andExpect(status().isBadRequest());
        }


}

package com.example.EmployeeInformation.EmpInfo.Employees;

import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.http.RequestEntity.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(EmployeeController.class)
//
//class EmployeeControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    EmployeeService service;
//
//    private Employee employee;
//
//
//    @BeforeEach
//    void setUp() {
//        BigDecimal b1 = new BigDecimal(33.55);
//        employee = Employee.builder()
//                .employeeName("Cody")
//                .employeeAddress("Quezon City")
//                .department("IT")
//                .departmentCode("IT-205")
//                .empSalary(b1)
//                .build();
//    }
//
//    @Test
//    void saveEmployee() throws Exception {
//        BigDecimal b1 = new BigDecimal(33.55);
//        Employee addEmployee = Employee.builder()
//                .employeeAddress("Quezon City")
//                .employeeName("Cody")
//                .department("IT")
//                .departmentCode("IT-205")
//                .empSalary(b1)
//                .build();
//        Mockito.when(service.saveEmployee(addEmployee)).thenReturn(employee);
//        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\n" +
//                                "     \n" +
//                                "     \"employeeName\":\"Kenley So\",\n" +
//                                "     \"department\":\"IT\",\n" +
//                                "     \"departmentCode\": \"IT-2003\",\n" +
//                                "     \"employeeAddress\": \"Quezon City\",\n" +
//                                "     \"empSalary\": 33.5\n" +
//                                "\n" +
//                                "}"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//
//
//    @Test
//    void fetchEmployeeById() throws Exception {
//
//        Mockito.when(service.fetchEmployeeById(1L)).thenReturn(employee);
//
//        mockMvc.perform(get("/employees/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.employeeName").
//                        value(employee.getEmployeeName()));
//    }
//}
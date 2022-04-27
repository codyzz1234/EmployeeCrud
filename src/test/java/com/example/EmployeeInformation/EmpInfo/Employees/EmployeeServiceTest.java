package com.example.EmployeeInformation.EmpInfo.Employees;

import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private EmployeeService service;

    @MockBean
    public EmployeeRepository repository;

    @BeforeEach
    void setUp() {
        BigDecimal b1 = new BigDecimal(33.55);
        Employee employee = Employee.builder()
                .employeeId(1L)
                .employeeName("Cody")
                .employeeAddress("Quezon City")
                .department("IT")
                .departmentCode("IT-205")
                .empSalary(b1)
                .build();
        Mockito.when(repository.findByemployeeNameIgnoreCase("Cody")).thenReturn(employee);
    }

    @Test
    @DisplayName("Add New Employee Test")
    public void whenEmployeeValid_ThenSave() throws EmployeeNotFoundException {
        Employee emp = service.fetchEmployeeByName("Cody");
        System.out.println("Employee ID is: " + emp.getEmployeeId());
        long employeeId = emp.getEmployeeId();;
        assertEquals(employeeId,emp.getEmployeeId());
    }



}
package com.example.EmployeeInformation.EmpInfo.Employees;

import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private TestEntityManager manager;

    @BeforeEach
    void setUp() {
        BigDecimal b1 = new BigDecimal(33.55);
        Employee employee = Employee.builder()
                .employeeName("Cody")
                .employeeAddress("Quezon City")
                .department("IT")
                .departmentCode("IT-205")
                .empSalary(b1)
                .build();
        manager.persist(employee);
    }

    @Test
    public void whenEmployeeFoundById_ThenGiveEmployee() throws EmployeeNotFoundException {
        Employee emp = repository.findById(1L).get();
        assertEquals(emp.getEmployeeName(),"Cody");

    }

    @Test
    public void searchEmployeeQuery(){
        List<Employee> emp = repository.findEmployeeByNameQuery("Kenley So");
        System.out.println(Arrays.toString(emp.toArray()));
    }

    @Test
    public void getAll(){
        List<Employee> emp = repository.getAllEmployeesQuery();
        System.out.println(Arrays.toString(emp.toArray()));
    }


}
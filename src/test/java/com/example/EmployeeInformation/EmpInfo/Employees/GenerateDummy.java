package com.example.EmployeeInformation.EmpInfo.Employees;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GenerateDummy {
    @Autowired
    private EmployeeRepository repository;

//    @Ignore
//    @Test
//    public void generateDummy(){
//        List<Employee> employees = new ArrayList<>();
//        for(int i = 0; i < 30; i++){
//            String name = "Employee " + i;
//            employees.add(new Employee(i,name,"IT Department","IT-2033","Quezon City",56));
//        }
//        for(Employee employee: employees){
//            repository.save(employee);
//        }
//    }
}

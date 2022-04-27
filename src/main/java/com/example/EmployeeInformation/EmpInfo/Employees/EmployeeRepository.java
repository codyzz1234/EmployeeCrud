package com.example.EmployeeInformation.EmpInfo.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee findByemployeeNameIgnoreCase(String employeeName);
}

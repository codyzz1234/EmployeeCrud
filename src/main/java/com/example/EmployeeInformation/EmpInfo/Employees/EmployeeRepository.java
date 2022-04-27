package com.example.EmployeeInformation.EmpInfo.Employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee findByemployeeNameIgnoreCase(String employeeName);

    @Query(
            value = "SELECT * from Employees where employee_name = ?1",
            nativeQuery = true)
    public List<Employee> findEmployeeByNameQuery(String name);

    @Query(
            value = "SELECT * from Employees",
            nativeQuery = true
    )
    public List<Employee> getAllEmployeesQuery();

}

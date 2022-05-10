package com.example.EmployeeInformation.EmpInfo.Employees;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(
        name = "Employees"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;

    @NotBlank(message = "Please Add Employee Name")
    @Column(name = "empName",
            nullable = false)
    private String employeeName;

    @NotBlank(message = "Please Add Employee Department")
    private String department;

    @NotBlank(message = "Please Add Employee DepartmentCode")
    private String departmentCode;

    @NotBlank(message = "Please Add Employee EmployeeAddress")
    private String employeeAddress;

    @DecimalMin(value = "0.0",inclusive = false,message = "Add A Employee Salary")
    private BigDecimal empSalary;


}

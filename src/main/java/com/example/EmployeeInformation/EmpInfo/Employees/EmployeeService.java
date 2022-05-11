package com.example.EmployeeInformation.EmpInfo.Employees;

import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeFailedToSaveException;
import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee employee) throws EmployeeFailedToSaveException {

        repository.save(employee);
        if(repository.findById(employee.getEmployeeId()).isEmpty()){
            throw new EmployeeFailedToSaveException();
        }
        else{
            return employee;
        }
    }


    public List <Employee> getAllEmployees() {
        return repository.findAll();
    }

    //



    public Employee fetchEmployeeById(long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = repository.findById(employeeId);
        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new EmployeeNotFoundException();
        }
    }

    public Employee fetchEmployeeByName(String employeeName) {
        return repository.findByemployeeNameIgnoreCase(employeeName);
    }

    public Employee updateEmployee(long employeeId,Employee employee) throws EmployeeNotFoundException {
        Optional <Employee> checker = repository.findById(employeeId);
        if(checker.isPresent()){
            Employee updatedEmployee = checker.get();
            updatedEmployee.setEmployeeName(employee.getEmployeeName());
            updatedEmployee.setDepartment(employee.getDepartment());
            updatedEmployee.setEmployeeAddress(employee.getEmployeeAddress());
            updatedEmployee.setEmpSalary(employee.getEmpSalary());
            updatedEmployee.setDepartmentCode(employee.getDepartmentCode());
            return repository.save(updatedEmployee);
        }
        else{
            throw new EmployeeNotFoundException();
        }
    }

    public void deleteEmployee(long employeeId) throws EmployeeNotFoundException {
        if(repository.existsById(employeeId)){
            repository.deleteById(employeeId);
        }
        else{
            throw new EmployeeNotFoundException();
        }
    }


    public Map<String, Object> empPagination(int page, int pageSize) {
        System.out.println("Page is: " + page);
        System.out.println("Page size is: " + pageSize);
        Pageable pageable = PageRequest.of(page,pageSize);
        Map<String,Object> response = new HashMap<>();
        response.put("data",repository.findAll(pageable).getContent());
        response.put("totalPage",repository.findAll(pageable).getTotalPages());
        response.put("currentPage",repository.findAll(pageable).getNumber());
        response.put("pageSize",repository.findAll(pageable).getSize());
        return response;
    }
}

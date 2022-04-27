package com.example.EmployeeInformation.EmpInfo.Employees;

import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeFailedToSaveException;
import com.example.EmployeeInformation.EmpInfo.ExceptionHandling.EmployeeNotFoundException;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    private Employee employee;


    @GetMapping("/")
    public String hello(){
        return "Welcome To Employee CRUD";
    }


    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee) throws EmployeeFailedToSaveException {
        return service.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchAllEmployees() throws EmployeeNotFoundException {
        List <Employee> employee = service.getAllEmployees();
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        else{
            return employee;
        }
    }

    @GetMapping("/employees/{id}")
    public Employee fetchEmployeeById(@PathVariable("id") long employeeId) throws EmployeeNotFoundException {
         return service.fetchEmployeeById(employeeId);

    }

    @GetMapping("/employees/name/{name}")
    public Employee fetchEmployeeById(@PathVariable("name") String employeeName) throws EmployeeNotFoundException {
        Optional<Employee> employee = Optional.ofNullable(service.fetchEmployeeByName(employeeName));
        if(employee.isPresent()){
            return service.fetchEmployeeByName(employeeName);
        }
        else{
            throw new EmployeeNotFoundException();
        }
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") long employeeId,@RequestBody Employee employee) throws EmployeeNotFoundException{
        return service.updateEmployee(employeeId,employee);
    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable("id") long employeeId) throws EmployeeNotFoundException{
        service.deleteEmployee(employeeId);
        return "Employee deleted Successfully";

    }


}

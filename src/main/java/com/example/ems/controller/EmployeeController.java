package com.example.ems.controller;

import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.listEmployee();
    }

    @PostMapping("employees/new")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    //build get employee by id REST API
    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.findEmployee(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id: " + id));
        return ResponseEntity.ok(employee);
    }

    //build update employee REST API
    @PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(employee);
    }

    //build delete employee REST API
    @DeleteMapping("employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

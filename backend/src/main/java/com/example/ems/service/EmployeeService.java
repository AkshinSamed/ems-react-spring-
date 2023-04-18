package com.example.ems.service;

import com.example.ems.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> listEmployee();
    Employee addEmployee(Employee employee);

    Optional<Employee> findEmployee(Long id);

    Employee updateEmployee(Long id, Employee employeeDetails);

    void deleteEmployee(Long id);
}

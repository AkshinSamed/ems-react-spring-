package com.example.ems.service.implement;

import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplement(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> listEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployee(Long id) {return employeeRepository.findById(id);}

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee =  employeeRepository
                                            .findById(id)
                                            .orElseThrow(
                                            () -> new ResourceNotFoundException("Employee not exist with Id: " + id) );
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());

        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository
                                            .findById(id)
                                            .orElseThrow(
                                            () -> new ResourceNotFoundException("Employee not exist with Id: " + id));
        employeeRepository.delete(employee);
    }
}

package com.solvedbymat.springrefresher.service.impl;

import com.solvedbymat.springrefresher.exception.ResourceNotFoundException;
import com.solvedbymat.springrefresher.model.Employee;
import com.solvedbymat.springrefresher.repository.EmployeeRepository;
import com.solvedbymat.springrefresher.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    public Employee updateEmployee(Employee employee, long id) {
        Employee existing = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        // if I remember, this saves and maps to db

        employeeRepository.save(existing);
        return existing;
    }

    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id)); // Throw condition before trying to delete.
        employeeRepository.deleteById(id);
    }

}

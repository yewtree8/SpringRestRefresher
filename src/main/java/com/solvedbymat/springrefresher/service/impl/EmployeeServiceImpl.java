package com.solvedbymat.springrefresher.service.impl;

import com.solvedbymat.springrefresher.exception.ResourceNotFoundException;
import com.solvedbymat.springrefresher.model.Employee;
import com.solvedbymat.springrefresher.repository.EmployeeRepository;
import com.solvedbymat.springrefresher.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}

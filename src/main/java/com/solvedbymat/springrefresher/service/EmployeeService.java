package com.solvedbymat.springrefresher.service;

import com.solvedbymat.springrefresher.model.Employee;

import java.util.List;


public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);


}

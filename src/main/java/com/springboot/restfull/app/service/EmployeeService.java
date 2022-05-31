package com.springboot.restfull.app.service;

import java.util.List;

import com.springboot.restfull.app.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee e,long id);
}

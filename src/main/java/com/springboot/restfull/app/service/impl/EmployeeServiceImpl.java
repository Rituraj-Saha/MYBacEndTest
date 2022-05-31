package com.springboot.restfull.app.service.impl;

import com.springboot.restfull.app.exception.ResourceNotFoundException;
import com.springboot.restfull.app.model.Employee;
import com.springboot.restfull.app.repository.EmployeeRepository;
import com.springboot.restfull.app.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	/*here for constructor injecttion we 
	dont need the autowired annotation
	as here is only one constructor and 
	spring bean automatically will add*/
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> emp = employeeRepository.findById(id);
//		if(emp.isPresent()) {
//			return emp.get();
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
		
		//lamda expression
		return employeeRepository.findById(id).orElseThrow(() ->
					new ResourceNotFoundException("Employee","Id",id));
	}

	@Override
	public Employee updateEmployee(Employee e, long id) {
		
		//check wheather a employee with given id exist in db
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","Id",id));
		existingEmployee.setFirstName(e.getFirstName());
		existingEmployee.setFirstName(e.getLastName());
		existingEmployee.setEmail(e.getEmail());
		
		//save existing to database
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
	}

}

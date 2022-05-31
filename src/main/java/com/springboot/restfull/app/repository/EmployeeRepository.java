package com.springboot.restfull.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restfull.app.model.Employee;


//JpaRepository<class,type_of_pk>
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

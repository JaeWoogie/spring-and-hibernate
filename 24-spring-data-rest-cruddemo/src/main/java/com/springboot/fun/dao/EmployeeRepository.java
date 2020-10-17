package com.springboot.fun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fun.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

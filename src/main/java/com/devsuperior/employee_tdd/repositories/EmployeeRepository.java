package com.devsuperior.employee_tdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.employee_tdd.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

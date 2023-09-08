package com.devsuperior.employee_tdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.employee_tdd.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}

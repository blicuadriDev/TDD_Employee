package com.devsuperior.employee_tdd.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.employee_tdd.dto.DepartmentDTO;
import com.devsuperior.employee_tdd.entities.Department;
import com.devsuperior.employee_tdd.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	
	public List<DepartmentDTO> findAll(){
		List<Department> dep = repository.findAll(Sort.by("name"));
		return dep.stream().map(x-> new DepartmentDTO(x)).collect(Collectors.toList());
	}
	
	

}

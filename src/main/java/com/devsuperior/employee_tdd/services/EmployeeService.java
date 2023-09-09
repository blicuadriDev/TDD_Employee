package com.devsuperior.employee_tdd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.employee_tdd.dto.EmployeeDTO;
import com.devsuperior.employee_tdd.entities.Department;
import com.devsuperior.employee_tdd.entities.Employee;
import com.devsuperior.employee_tdd.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Transactional(readOnly=true)
	public Page<EmployeeDTO> findAll(Pageable pageable){
		Page<Employee> result = repository.findAll(pageable);
		return result.map(x-> new EmployeeDTO(x));
	}
	
	@Transactional
	public EmployeeDTO insert(EmployeeDTO dto) {
		Employee entity = new Employee();
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setDepartment(new Department(dto.getDepartmentId(), null));
		
		entity = repository.save(entity);
		return new EmployeeDTO(entity);
	}

}

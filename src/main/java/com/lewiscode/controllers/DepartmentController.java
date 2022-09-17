package com.lewiscode.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewiscode.models.Department;
import com.lewiscode.services.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	
	@Autowired
	DepartmentService departmentService;
	

	
	@GetMapping()
	public ResponseEntity<List<Department>> getAll()
	{
		List<Department> departments = departmentService.getDepartments();
		
		
		return ResponseEntity.ok().body(departments);
		
	}
	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Department> getById(@PathVariable int id)
	{
		
		Department department = departmentService.getDepartmentById(id);
		
		return ResponseEntity.ok().body(department);
	}
	
}

package com.lewiscode.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewiscode.models.Department;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	
	
	@GetMapping()
	public ResponseEntity<List<Department>> getDepartments()
	{
		List<Department> departments = new ArrayList<>();
		
		
		Department departmentOne = new Department(1,"Sales");
		Department departmentTwo = new Department(1,"Marketing");
		
		departments.add(departmentOne);
		departments.add(departmentTwo);
		
		return ResponseEntity.ok().body(departments);
		
	}
	
	
}

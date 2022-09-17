package com.lewiscode.services;

import java.util.List;

import com.lewiscode.models.Department;

public interface DepartmentService {

	
	public List<Department> getDepartments();
	
	public Department getDepartmentById(int id);
	
	
	
	
}

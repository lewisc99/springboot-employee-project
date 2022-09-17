package com.lewiscode.dao;

import java.util.List;

import com.lewiscode.models.Department;

public interface DepartmentDAO {

	public List<Department> getDepartments();
	
	public Department getDepartmentById(int id);
	
	
}

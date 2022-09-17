package com.lewiscode.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewiscode.dao.DepartmentDAO;
import com.lewiscode.models.Department;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

	
	@Autowired
	DepartmentDAO departmentDAO;
	
	
	
	@Override
	@Transactional
	public List<Department> getDepartments() {
		
		
		return departmentDAO.getDepartments();
	}

	@Override
	@Transactional
	public Department getDepartmentById(int id) {
	
		return departmentDAO.getDepartmentById(id);
		
		
	}

}

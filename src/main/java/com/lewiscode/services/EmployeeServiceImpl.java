package com.lewiscode.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.lewiscode.dao.EmployeeDAO;
import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;

public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Override
	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee updateEmployee(int ind, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

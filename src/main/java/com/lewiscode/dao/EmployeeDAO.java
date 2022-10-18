package com.lewiscode.dao;

import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeCreation;
import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;

public interface EmployeeDAO {

	

	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee);
	
	public Employee getEmployeeById(int id);
	
	public void addEmployee( EmployeeCreation employee);
	
	public Employee updateEmployee( int ind, Employee employee);
	
	public void deleteEmployee( int id);
	
	
}

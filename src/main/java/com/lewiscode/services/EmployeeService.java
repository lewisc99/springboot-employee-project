package com.lewiscode.services;


import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeCreation;
import com.lewiscode.models.dto.EmployeesDTO;

public interface EmployeeService {

	
	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee);
	
	public Employee getEmployeeById(int id);
	
	public void addEmployee( EmployeeCreation employee);
	
	public Employee updateEmployee( int ind, Employee employee);
	
	public void deleteEmployee( int id);
	
	
}

package com.lewiscode.services;

import com.lewiscode.models.dto.EmployeeCreation;
import org.springframework.beans.factory.annotation.Autowired;

import com.lewiscode.dao.EmployeeDAO;
import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Override
	@Transactional
	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee) {



		return employeeDAO.getEmployees(pagNumber,pagSize,urlEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {


		 return employeeDAO.getEmployeeById(id);
	}


	@Transactional
	@Override
	public void addEmployee(EmployeeCreation employee) {

		employeeDAO.addEmployee(employee);
		
	}



	@Transactional
	@Override
	public Employee updateEmployee(int id, EmployeeCreation employee) {
		return employeeDAO.updateEmployee(id, employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {

		employeeDAO.deleteEmployee(id);
		
	}

	
	
	
}

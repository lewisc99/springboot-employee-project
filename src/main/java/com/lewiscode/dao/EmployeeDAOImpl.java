package com.lewiscode.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {

		try
		{

			Session session = entityManager.unwrap(Session.class);

			Employee employeeById = session.get(Employee.class, id);

			return employeeById;

		} catch (Exception e)
		{
			e.getStackTrace();
			throw new RuntimeException(e.getMessage());
		}


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

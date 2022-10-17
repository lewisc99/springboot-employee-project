package com.lewiscode.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public EmployeesDTO getEmployees(int pagNumber, int pagSize, String urlEmployee) {


		try {

			Session currentSession = entityManager.unwrap(Session.class);


			List<Employee> employees = currentSession.createQuery("from Employee order by id").getResultList();
			EmployeesDTO employeesDTO = new EmployeesDTO();
			int employeesSize = employees.size();

			if (pagNumber < 1 && pagSize > 1)
			{
				pagNumber = 1;
			}
			if ((pagNumber <= 0) && (pagSize <= 0 ))
			{
				employeesDTO.addEmployees(employees, urlEmployee);
				return employeesDTO;
			}
			else
			{
				List<Employee> takeEmployees = employees.stream().skip((pagNumber - 1) * pagSize).limit(pagSize).toList();
				int employeeTotalPages = (int) Math.ceil((double) employeesSize / pagSize);

				employeesDTO.addPage(pagSize,employeesSize, employeeTotalPages,pagNumber);
				System.out.print(takeEmployees);

				employeesDTO.addEmployees(takeEmployees, urlEmployee);

				return employeesDTO;
			}


		}
		catch (Exception e)
		{
			e.getStackTrace();
			throw new RuntimeException(e.getMessage());
		}

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
	public void addEmployee(Employee employee)
	{
		try
		{
			Session currentSession = entityManager.unwrap(Session.class);

			employee.setId(0);

			currentSession.save(employee);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
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

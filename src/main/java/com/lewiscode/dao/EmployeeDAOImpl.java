package com.lewiscode.dao;

import javax.persistence.EntityManager;

import com.lewiscode.models.Department;
import com.lewiscode.models.dto.EmployeeCreation;
import com.lewiscode.services.DepartmentService;
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

	@Autowired
	private DepartmentService departmentService;
	
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
	public void addEmployee(EmployeeCreation employeeCreation)
	{
		try
		{
			Session currentSession = entityManager.unwrap(Session.class);

			//employee.setId(0);

			Department getDepartment = departmentService.getDepartmentById(employeeCreation.getDepartment());

			//public Employee(int id, String name, String email, Department department)
			Employee employee = new Employee(employeeCreation.getName(), employeeCreation.getEmail(),  getDepartment);

			currentSession.save(employee);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
	@Override
	public Employee updateEmployee(int id, EmployeeCreation newEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);

		Department department = departmentService.getDepartmentById(newEmployee.getDepartment());

		Employee currentEmployee = getEmployeeById(id);
		currentEmployee.setDepartment(department);

		Employee updatedEmployee = authorizedChangeProperty(currentEmployee, newEmployee );

		currentSession.save(updatedEmployee);
		return updatedEmployee;
	}



	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
	}


	public Employee authorizedChangeProperty(Employee currentEmployee, EmployeeCreation newEmployee)
	{

		currentEmployee.setEmail(newEmployee.getEmail());
		currentEmployee.setName(newEmployee.getName());

		return currentEmployee;

	}

}

package com.lewiscode.dao;

import java.util.List;

import javax.persistence.EntityManager;


import com.lewiscode.models.Employee;
import org.hibernate.Session;



import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewiscode.models.Department;



@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public List<Department> getDepartments() {
		
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		
	    Query<Department> theQuery = 
	    		currentSession.createQuery("from Department", Department.class);
	    
	    List<Department> departments = theQuery.getResultList();
	 
	
		return departments;
	}

	@Override
	public Department getDepartmentById(int id) {
		
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		 Department department = currentSession.get(Department.class, id);
		 
		 return department;
		
		
	}



}

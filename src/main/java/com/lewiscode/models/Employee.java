package com.lewiscode.models;

import com.lewiscode.models.dto.EmployeeCreation;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="employee")
public class Employee  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	


	@NotNull(message = "Name cannot be null")
	@Min(value = 5, message = "Name should be at least 5 characters")
	@Column(name="name")
	private String name;


	@NotNull(message = "Email cannot be null")
	@Column(name="email")
	private String email;


	@JoinColumn(name="department_id")
	@ManyToOne
	private Department department;


	
	
	public Employee()
	{}


	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	
	}

	public Employee(String name, String email, Department department) {
		this.name = name;
		this.email = email;
		this.department  = department;
	}

	public Employee(String name, String email) {
		this.name = name;
		this.email = email;
	
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
}

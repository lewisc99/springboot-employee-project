package com.lewiscode.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Table(name="department")
@Entity
public class Department  implements Serializable {
	

	@Serial
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="name")
	private String name;


	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
	public Department()
	{}

	public Department(int id, String name) {
		
		this.id = id;
		this.name = name;
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
	
	
	
	

}

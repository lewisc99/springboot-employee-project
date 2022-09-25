package com.lewiscode.models.dto;

import java.util.ArrayList;
import java.util.List;

import com.lewiscode.models.Employee;
import com.lewiscode.models.Page;

public class EmployeesDTO {

	
	private List<EmployeeDTO> _embedded = new ArrayList<>();
	
	private List<Link> links = new ArrayList<>();
	
	private Page page;
	
	




	public List<EmployeeDTO> get_embedded() {
		return _embedded;
	}


	public void set_embedded(List<EmployeeDTO> _embedded) {
		this._embedded = _embedded;
	}


	public List<Link> getLinks() {
		return links;
	}


	public void setLinks(List<Link> links) {
		this.links = links;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}
	
	public void addLink(String link, String rel)
	{
		links.add(new Link(link,rel));
	}
	
	public void addEmployees(List<Employee> employees, String url)
	{
		for(Employee employee:employees)
		{
			EmployeeDTO employeeDTO = new EmployeeDTO(employee);
			employeeDTO.AddLink(url + employee.getId(), "self");
			
			_embedded.add(employeeDTO);
		}
	}
	
	public void addPage(int size, int totalElements, int totalPages,int number )
	{
		 this.page = new Page(size,totalElements,totalPages,number);

	}
	
}

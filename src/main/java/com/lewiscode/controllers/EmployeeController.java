package com.lewiscode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;
import com.lewiscode.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController{

	
	@Autowired
	private EmployeeService employeeService;

	
	@GetMapping()
	public ResponseEntity<EmployeesDTO> returnAll(@RequestParam(value="pagNumber", required=false) Integer pagNumber,
			@RequestParam(value="pagSize", required=false) Integer pagSize, HttpServletRequest request)
	{
		
		
		if(pagNumber == null && pagSize == null)
		{
			pagNumber = 0;
			pagSize = 0;
		}
		
		String fullUrl = request.getRequestURI().toString();
		String urlForEmployees = request.getRequestURI().toString();
		
		
		EmployeesDTO employeesDTO = employeeService.getEmployees(pagNumber, pagSize, fullUrl);
		
		if (!(pagNumber <= 0 && pagSize <= 0))
		{
			urlForEmployees += "?pagNumber=" + pagNumber + "&pagSize" + pagSize;
		}
		
		
		employeesDTO.addLink(urlForEmployees, "getAllEmployees");
		
		
		if (employeesDTO.get_embedded().isEmpty())
		{
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok().body(employeesDTO);
	
		
	}
	
	
	
	
}

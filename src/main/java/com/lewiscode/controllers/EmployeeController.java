package com.lewiscode.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.lewiscode.exceptions.CustomNotFoundException;
import com.lewiscode.models.Employee;
import com.lewiscode.models.dto.EmployeeCreation;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lewiscode.models.dto.EmployeeDTO;
import com.lewiscode.models.dto.EmployeesDTO;
import com.lewiscode.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;


	@GetMapping()
	public ResponseEntity<EmployeesDTO> returnAll(@RequestParam(value = "pagNumber", required = false) Integer pagNumber,
												  @RequestParam(value = "pagSize", required = false) Integer pagSize, HttpServletRequest request) {


		if (pagNumber == null && pagSize == null) {
			pagNumber = 0;
			pagSize = 0;
		}

		String fullUrl = request.getRequestURI().toString();
		String urlForEmployees = request.getRequestURI().toString();


		EmployeesDTO employeesDTO = employeeService.getEmployees(pagNumber, pagSize, fullUrl);

		if (!(pagNumber <= 0 && pagSize <= 0)) {
			urlForEmployees += "?pagNumber=" + pagNumber + "&pagSize" + pagSize;
		}


		employeesDTO.addLink(urlForEmployees, "getAllEmployees");


		if (employeesDTO.get_embedded().isEmpty()) {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok().body(employeesDTO);


	}


	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> returnById(@PathVariable int id, HttpServletRequest request) {

		Employee employeeId = employeeService.getEmployeeById(id);

		if (employeeId == null) {
			throw new CustomNotFoundException("Id not found");
		}

		String fullUrl = request.getRequestURL().toString();

		EmployeeDTO employeeDTO = new EmployeeDTO(employeeId);

		employeeDTO.AddLink(fullUrl, "self");

		return ResponseEntity.ok().body(employeeDTO);

	}


	@PostMapping
	public ResponseEntity<Void> Create(@RequestBody @Valid EmployeeCreation employeeCreation) {
		if (employeeCreation == null) {
			throw new RuntimeException("Employee is empty");
		}



		employeeService.addEmployee(employeeCreation);

		return ResponseEntity.status(201).build();
	}



	
	
}

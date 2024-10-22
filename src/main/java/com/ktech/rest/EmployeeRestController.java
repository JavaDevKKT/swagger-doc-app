package com.ktech.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ktech.entity.Employee;
import com.ktech.service.EmployeeServiceImpl;

@RestController
public class EmployeeRestController {
	private EmployeeServiceImpl employeeServiceImpl;

	public EmployeeRestController(EmployeeServiceImpl employeeServiceImpl) {
		super();
		this.employeeServiceImpl = employeeServiceImpl;
	}

	@PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		try {
			Employee saveEmployee = employeeServiceImpl.saveEmployee(employee);

			return new ResponseEntity<>("Save Employee Successfully...", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Something went wrong...!", HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<Employee>> getListOfEmployee() {
		List<Employee> employees = employeeServiceImpl.getEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = employeeServiceImpl.getEmployee(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}

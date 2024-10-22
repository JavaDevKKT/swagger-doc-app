package com.ktech.service;

import java.util.List;
import java.util.Optional;
import com.ktech.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getEmployees();

	public Employee getEmployee(Long id);

	public void deleteEmployee(Long id);

	public Employee updateEmployee(Employee employee);
}

package service;

import java.util.List;

import entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Long id);
	
	Employee updateEmployeeById(Long id);
	
	void deleteEmployeeById(Long id);

}

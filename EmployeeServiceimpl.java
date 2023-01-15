package service;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import entity.Employee;
import repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public  (EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	@Override
	public List<employee> getAllEmployees(){return employeeRepository.findAll();}
		
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	@Override
	public void deleteEmployeeById(Long id) {
		return employeeRepository.deleteByID(id);
		
	}
	

}

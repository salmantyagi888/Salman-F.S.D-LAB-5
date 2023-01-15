package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import entity.Employee;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;

	}

	@GetMapping("/employees")
	public String listemployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createemployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee)
		return"create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@modelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/emploees/edit/{id}")
	public String editemployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employee/{id}")
	public String updateemployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";

	}

	@GetMapping("/employee/{id}")
	public String deleteemployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}

}

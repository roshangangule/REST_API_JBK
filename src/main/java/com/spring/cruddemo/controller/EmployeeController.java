package com.spring.cruddemo.controller;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cruddemo.entity.Country;
import com.spring.cruddemo.entity.Employee;
import com.spring.cruddemo.error.EmployeeNotFoundException;
import com.spring.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeSevice;

	public EmployeeController(EmployeeService theEmployeeDao) {
		employeeSevice = theEmployeeDao;
	}

	@GetMapping("/hello")
	public String hello() {

		return "Hello World!";
	}

	// GetMapping for employee
	//1
	@GetMapping("/employees")
	public List<Employee> getEmployees() {

		return employeeSevice.findAll();

	}
	
	//2

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeesById(@PathVariable int employeeId) {
		Employee employee = employeeSevice.findById(employeeId);
		if(employee == null) {
			throw new EmployeeNotFoundException("Employee id not found - "+employeeId);
		}
		
		return employee;

	}

	//3
	
	@GetMapping("/employees/status/{status}")
	public List<Employee> getEmployeesByStatus(@PathVariable String status) {

		List<Employee> employees = employeeSevice.findByStatus(status);
		if(employees == null) {
			throw new EmployeeNotFoundException("Employee id not found- "+status);
		}
		
		return employees;

	}
	
	//11
	
	@GetMapping("/employeesbyname/{name}")
	public List<Employee> getEmployeeByName(@PathVariable String name) {
		
		
		List<Employee> employee = employeeSevice.getEmployeeByName(name);
		
		return employee;
	}
	
	//10
	
	@GetMapping("/employees/listofemployeebeforetoday")
	public List<Employee> getEmployeeByDate(){
		
		LocalDateTime time = java.time.LocalDateTime.now();
		
		time = time.with(LocalTime.MIDNIGHT);
		
		List<Employee> employees = employeeSevice.getEmployeeByDate(time);
		
		
		return employees;
	}
	
	//4
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {

		employee.setId(0);

		LocalDateTime time = java.time.LocalDateTime.now();
		
		employee.setCreateddtm(time);
		employee.setUpdateddtm(time);


		employeeSevice.save(employee);

		return "Employee added successfully.";
	}
	
	//5
	
	@PutMapping("/employees")
	public String updateEmployee(@RequestBody Employee employee) {

		LocalDateTime time = java.time.LocalDateTime.now();
		
		employee.setUpdateddtm(time);

		
		

		employeeSevice.save(employee);

		return "Employee updated successfully.";
	}
	
	//6
	@GetMapping("/countries")
	public List<Country> getCountries(){
		
		
		return employeeSevice.findAllCountries();
	}
	
	//7
	
	@PostMapping("/countries")
	public String saveCountries(@RequestBody Country country) {
		
		country.setId(0);
		
		employeeSevice.saveCountry(country);
		
		
		return "Country added successfully.";
	}
	
	//8
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		int i = employeeSevice.deleteById(employeeId);
		
		if(i == 0) {
			throw new EmployeeNotFoundException("Employee id is not found - "+employeeId);
		}
		
		return "Employee deleted!";
	}
	
	//9
	
	
	@DeleteMapping("/countries/{countryId}")
	public String deleteCountries(@PathVariable int countryId) {
		
		
		employeeSevice.deleteCountryById(countryId);
		
		return "Country deleted!";
	}
	
	
	
	
	
	
	
}

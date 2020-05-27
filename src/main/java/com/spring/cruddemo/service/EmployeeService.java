package com.spring.cruddemo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.spring.cruddemo.entity.Country;
import com.spring.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public void save(Employee employee);

	public Employee findById(int employeeId);

	public List<Employee> findByStatus(String status);

	public List<Country> findAllCountries();

	public void saveCountry(Country country);

	public int deleteById(int employeeId);

	public void deleteCountryById(int countryId);

	public List<Employee> getEmployee();

	public List<Employee> getEmployeeByDate(LocalDateTime time);

	public List<Employee> getEmployeeByName(String name);
}

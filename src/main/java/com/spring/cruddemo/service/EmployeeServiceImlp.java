package com.spring.cruddemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cruddemo.dao.EmployeeDAO;
import com.spring.cruddemo.entity.Country;
import com.spring.cruddemo.entity.Employee;


@Service
public class EmployeeServiceImlp implements EmployeeService{

	
	@Autowired
	private EmployeeDAO employeeDao;
	
	public EmployeeServiceImlp(EmployeeDAO theEmployeeDAO) {
		
		employeeDao = theEmployeeDAO;
	}
	
	@Override
	public void save(Employee employee) {
		
		employeeDao.save(employee);
	}

	@Override
	public Employee findById(int employeeId) {
		
		return employeeDao.findById(employeeId);
	}

	@Override
	public List<Employee> findByStatus(String status) {
		
		return employeeDao.findAll();
	}

	@Override
	public List<Country> findAllCountries() {
	
		return employeeDao.findAllCountries();
	}

	@Override
	public void saveCountry(Country country) {
		employeeDao.saveCountry(country);
	}

	@Override
	public int deleteById(int employeeId) {
		
		return employeeDao.deleteById(employeeId);
	}

	@Override
	public void deleteCountryById(int countryId) {
		employeeDao.deleteCountryById(countryId);
	}

	@Override
	public List<Employee> getEmployee() {
		
		return employeeDao.getEmployee();
	}

	@Override
	public List<Employee> getEmployeeByDate(LocalDateTime time) {
		
		return employeeDao.getEmployeeByDate(time);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		
		return employeeDao.getEmployeeByName(name);
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

}

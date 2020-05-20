package com.spring.cruddemo.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.cruddemo.entity.Country;
import com.spring.cruddemo.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	public EmployeeDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;

	}

	@Override
	public List<Employee> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employees = theQuery.getResultList();

		return employees;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);

	}

	@Override
	public Employee findById(int employeeId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Employee employee = currentSession.get(Employee.class, employeeId);

		return employee;
	}

	@Override
	public List<Employee> findByStatus(String status) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("from Employee where status=:status");
		query.setParameter("status", status);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public List<Country> findAllCountries() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("from Country", Country.class);

		List<Country> countries = query.getResultList();

		return countries;
	}

	@Override
	public void saveCountry(Country country) {
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(country);

	}

	@Override
	public int deleteById(int employeeId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");

		query.setParameter("employeeId", employeeId);

		int i = query.executeUpdate();
		return i;
	}

	@Override
	public void deleteCountryById(int countryId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("delete from Employee where id=:countryId");

		query.setParameter("countryId", countryId);

		query.executeUpdate();

	}

	@Override
	public List<Employee> getEmployee() {
		Session currentSession = entityManager.unwrap(Session.class);

		return null;
	}

	@Override
	public List<Employee> getEmployeeByDate(LocalDateTime time) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("from Employee where createddtm <:time");
		query.setParameter("time", time);

		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("from Employee where name=:name");
		
		query.setParameter("name", name);

		List<Employee> employee = query.getResultList();
		
		return employee;
	}

}

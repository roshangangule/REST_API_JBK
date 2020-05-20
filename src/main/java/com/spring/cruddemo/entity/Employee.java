package com.spring.cruddemo.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "dept")
	private String dept;

	@Column(name = "status")
	private String status;

	@Column(name = "createddtm")
	private LocalDateTime createddtm;

	@Column(name = "createdby")
	private String createdBy;

	@Column(name = "updateddtm")
	private LocalDateTime updateddtm;

	@Column(name = "updatedby")
	private String updatedBy;
	
	@OneToOne
	@JoinColumn(name = "cid")
	private Country theCountry;

	

	public Employee() {

	}
	
	public Employee(String name, String phone, String dept, String status, LocalDateTime createddtm, String createdBy,
			LocalDateTime updateddtm, String updatedBy) {
		this.name = name;
		this.phone = phone;
		this.dept = dept;
		this.status = status;
		this.createddtm = createddtm;
		this.createdBy = createdBy;
		this.updateddtm = updateddtm;
		this.updatedBy = updatedBy;
	}



	public void setCreateddtm(LocalDateTime time) {
		this.createddtm = time;
	}

	public void setUpdateddtm(LocalDateTime updateddtm) {
		this.updateddtm = updateddtm;
	}

	public LocalDateTime getCreateddtm() {
		return createddtm;
	}

	public LocalDateTime getUpdateddtm() {
		return updateddtm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Country getTheCountry() {
		return theCountry;
	}

	public void setTheCountry(Country theCountry) {
		this.theCountry = theCountry;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", dept=" + dept + ", status=" + status
				+ ", createddtm=" + createddtm + ", createdBy=" + createdBy + ", updateddtm=" + updateddtm
				+ ", updatedBy=" + updatedBy + ", theCountry=" + theCountry + "]";
	}

}

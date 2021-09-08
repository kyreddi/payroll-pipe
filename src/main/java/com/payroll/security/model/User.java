package com.payroll.security.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="salary")
	private String salary;
	
@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emailId=" + emailId + ", mobile=" + mobile + ", gender="
				+ gender + ", salary=" + salary + ", password=" + password + "]";
	}

public User(String id, String name, String emailId, String mobile, String gender, String salary, String password) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobile = mobile;
		this.gender = gender;
		this.salary = salary;
		this.password = password;
	}

//	@Column(name="pan")
//	private String pan;
//	
//	@Column(name="hired_date")
//	private Date hiredDate;
	
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Column(name="Password")
	private String password;

	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

//	public String getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(String department) {
//		this.department = department;
//	}
//
//	public Date getHiredDate() {
//		return hiredDate;
//	}
//
//	public void setHiredDate(Date hiredDate) {
//		this.hiredDate = hiredDate;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

//	public User(String id, String name, String emailId, String mobile, String gender,
//			String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.emailId = emailId;
//		this.mobile = mobile;
//		this.gender = gender;
////		this.adhar_number = adhar_number;
////		this.pan = pan;
////		this.hiredDate = hiredDate;
//		this.password = password;
//	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

//	public String getPan() {
//		return pan;
//	}

//	public String getAdhar_number() {
//		return adhar_number;
//	}

//	public void setAdhar_number(String adhar_number) {
//		this.adhar_number = adhar_number;
//	}
//
//	public void setPan(String pan) {
//		this.pan = pan;
//	}

//	public User(String name, String emailId, String password) {
//		super();
//		this.name = name;
//		this.emailId = emailId;
//		this.password = password;
//	}

//	public User(String emailId, String password) {
//		super();
//		this.emailId = emailId;
//		this.password = password;
//	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public User(String id, String name, String emailId, String gender,
//			String password) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.emailId = emailId;
//		this.gender = gender;
////		this.adhar_number = adhar_number;
////		this.pan = pan;
//		this.password = password;
//	}


	
	
	

}

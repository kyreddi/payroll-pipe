package com.payroll.security.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpForm {
	private String id;
	

    private String name;

    private String emailId;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private String mobile;
    private String gender;
    private String salary;
    private String password;
    
    
    
    
    
public SignUpForm() {
		super();
		// TODO Auto-generated constructor stub
	}





public SignUpForm(String id, String name, String emailId, String mobile, String gender, String salary,
		String password) {
	super();
	this.id = id;
	this.name = name;
	this.emailId = emailId;
	this.mobile = mobile;
	this.gender = gender;
	this.salary = salary;
	this.password = password;
}

//	public SignUpForm(String name, String emailId, String password) {
//		super();
//		this.name = name;
//		this.emailId = emailId;
//		this.password = password;
//	}

	@Override
public String toString() {
	return "SignUpForm [id=" + id + ", name=" + name + ", emailId=" + emailId + ", mobile=" + mobile + ", gender="
			+ gender + ", salary=" + salary + ", password=" + password + "]";
}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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


    
  
}
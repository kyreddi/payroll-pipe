package com.payroll.security.response;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String id;
	private String name;
	private String token;
	private String type = "Bearer";
	private String username;
	private String gender;
	private String salary;
//	private String pan;
//	private String city;
	private String mobile;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String id,String name,String accessToken, String username, Collection<? extends GrantedAuthority> authorities) {
		this.id=id;
		this.name=name;
		this.token = accessToken;
		this.username = username;
		this.authorities = authorities;
	}
	

	public JwtResponse(String id, String name, String token, String username,String mobile, String gender, String salary,
			 Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.token = token;
		this.username = username;
		this.mobile=mobile;
		this.gender = gender;
		this.salary = salary;
//		this.pan=pan;
//		this.hiredDate = hiredDate;
		this.authorities = authorities;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

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
//
//
//	public String getCity() {
//		return city;
//	}
//
//
//	public void setCity(String city) {
//		this.city = city;
//	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


//	public String getAdhar_number() {
//		return adhar_number;
//	}
//
//
//	public void setAdhar_number(String adhar_number) {
//		this.adhar_number = adhar_number;
//	}
//
//
//	public String getPan() {
//		return pan;
//	}
//
//
//	public void setPan(String pan) {
//		this.pan = pan;
//	}
	
	
	
    
}
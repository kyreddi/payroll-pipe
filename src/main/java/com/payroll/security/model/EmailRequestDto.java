package com.payroll.security.model;

import javax.validation.constraints.Email;

public class EmailRequestDto {
	
	
	@Email(message = "Invalid Email address")
    private String email;
    
    private String body;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public EmailRequestDto(@Email(message = "Invalid Email address") String email, String body) {
		super();
		this.email = email;
		this.body = body;
	}
	
	

}

package com.org.security.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignUpForm {
    
    private String name;



    private String email;
    

    
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

	
}
package com.payroll.security.dao;

import com.payroll.security.model.UserEntity;

public interface OAuthDAOService {

	public UserEntity getUserDetails(String emailId);
}

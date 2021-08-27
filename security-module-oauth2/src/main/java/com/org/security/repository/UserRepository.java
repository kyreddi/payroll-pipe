package com.org.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.security.model.User;
//import com.org.security.model.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	boolean existsByEmailId(String email);

}

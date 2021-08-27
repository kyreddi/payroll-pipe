package com.payroll.security.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.security.model.Role;
import com.payroll.security.model.RolePermission;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{

	public Role findByroleID(int roleId);


	 public Role findByroleName(String roleName);


}

package com.payroll.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payroll.security.model.ResourcePermission;
import com.payroll.security.model.Role;
import com.payroll.security.model.RolePermission;
@Repository
public interface PermissionRepository extends JpaRepository<RolePermission,Integer> {

	List<RolePermission> findByroleId(int roleId);

	RolePermission  findByRoleIdAndResourceId(int roleId, int resourceId);

	
	//RolePermission findByRoleName(int roleId);

	//public void findByRoleName();
	
	//List<RolePermission> findByroleName(String roleName);

	
	
}

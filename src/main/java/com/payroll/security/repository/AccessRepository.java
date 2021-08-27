package com.payroll.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payroll.security.model.Resource;
import com.payroll.security.model.RolePermission;

@Repository
public interface AccessRepository extends JpaRepository<Resource,Integer> {

	RolePermission save(RolePermission rolePermission);

}

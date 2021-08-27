package com.payroll.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payroll.security.model.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

}

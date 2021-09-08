package com.payroll.security.config;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.payroll.security.model.ResourcePermission;

public class PermissionGrantedAuthority implements GrantedAuthority{ 

	public PermissionGrantedAuthority(List<ResourcePermission> resourcePermissions) {
		super();
		this.resourcePermissions = resourcePermissions;
	}

	public List<ResourcePermission> getResourcePermissions() {
		return resourcePermissions;
	}

	public void setResourcePermissions(List<ResourcePermission> resourcePermissions) {
		this.resourcePermissions = resourcePermissions;
	}

	private List<ResourcePermission> resourcePermissions;
	

	@Override
	public String toString() {
		return "PermissionGrantedAuthority [resourcePermissions=" + resourcePermissions + "]";
	}

	@Override
	public String getAuthority() {

	
		return resourcePermissions.toString();
	}

	


}
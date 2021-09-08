package com.payroll.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payroll.security.model.Resource;
import com.payroll.security.model.ResourcePerm;
import com.payroll.security.model.Role;
import com.payroll.security.model.RolePermission;
import com.payroll.security.model.User;
import com.payroll.security.model.User_Role;
import com.payroll.security.service.AccessService;

@RestController
@RequestMapping("/api/access")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccessController {
	


	@Autowired
	private AccessService accessService;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {



	return accessService.getAllUsers();
	}
	

	@PostMapping("/addResource")
//	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	public Resource addResource(@RequestBody Resource resource) {

		return accessService.addResource(resource);
	}
	
	
	//DELTE RESOURCE BY ID
	@DeleteMapping("/deleteResource/{id}")
	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	public String deleteResource(@PathVariable int id) {

		return accessService.deleteResource(id);
	}

	@PostMapping("/grantPerm")
//	@PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
	public RolePermission grantPermissions(@RequestBody RolePermission rolePermission) {

		return accessService.grantPermissions(rolePermission);
	}

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {

		return accessService.addRole(role);

	}
	
	@PostMapping("/setRole")
	public String setRole(@RequestBody User_Role userRole) {
		

		

		return accessService.setRole(userRole);

	}
	
	//DELETE ROLE BY ID
	@DeleteMapping("/deleteRole/{id}")
	public String deleteRole(@PathVariable int id) {

		return accessService.deleteRole(id);

	}

	
	
	
	@GetMapping("/getroleByRoleId/{roleID}")
	public Role getRoleByRoleID(@PathVariable int roleID) {

		return accessService.getRoleByRoleID(roleID);
	}
	@GetMapping("/getuserByid/{id}")
	public User getUserByid(@PathVariable String id) {

		return accessService.getUserByid(id);
	}

	@GetMapping("/getByRoleName/{roleName}")
	public Role getByRoleName(@PathVariable String roleName) {

		return accessService.getByRoleName(roleName);
	}

	@PostMapping("/createRolewithPerm")
	public String createRoleWithPermissions(@RequestBody ResourcePerm resourcePerm) {

		
		Role role = new Role();

		role.setRoleName(resourcePerm.getRoleName());

		Role roledata = accessService.addRole(role);



		for (RolePermission p : resourcePerm.getPermissionList()) {

			p.setRoleId(roledata.getRoleID());
		}


		for (RolePermission p : resourcePerm.getPermissionList()) {
			accessService.grantPermissions(p);
		}
		return "successFully created";

	}

	@PutMapping("/updatepermissionsByRoleID")
	public String updatepermissionsByRoleIDAndResourceId(@RequestBody ResourcePerm resourcePerm) {



		return accessService.updatepermissionsByRoleIDAndResourceId(resourcePerm);

	}

	
	  @GetMapping("/getPermissionsByRoleName/{roleName}")
	  public ResourcePerm getPermissionsByRoleName(@PathVariable String roleName){
		  
		  Role role=getByRoleName(roleName);
		  
		  List<RolePermission> rolepermlist=  accessService.getPermissionsByRoleId(role.getRoleID());
		  
		  ResourcePerm resourcePerm=new ResourcePerm();
		  
		  resourcePerm.setRoleName(roleName);
		  resourcePerm.setPermissionList(rolepermlist);
		  
		  
	  return resourcePerm;
	  }
	 
	  

	@GetMapping("/getpermissions/{roleID}")
	public List<RolePermission> getPermissionsByRoleId(@PathVariable int roleID) {

		return accessService.getPermissionsByRoleId(roleID);
	}
	
	
	@GetMapping("/viewAllRoles")
	public List<Role> getAllRoles(){
		return accessService.getAllRoles();
	}


    
	@DeleteMapping("/deleteX/{id}")
	 public String deleteRoleById(Integer roleId) {
		return accessService.deleteRoleById(roleId);
	}
	
	
	
	
}

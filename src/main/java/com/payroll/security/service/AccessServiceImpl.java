package com.payroll.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payroll.security.model.Resource;
import com.payroll.security.model.ResourcePerm;
import com.payroll.security.model.Role;
import com.payroll.security.model.RolePermission;
import com.payroll.security.model.User;
import com.payroll.security.model.User_Role;
import com.payroll.security.repository.AccessRepository;
import com.payroll.security.repository.PermissionRepository;
import com.payroll.security.repository.RolePermissionRepository;
import com.payroll.security.repository.RoleRepository;
import com.payroll.security.repository.UserRepository;
import com.payroll.security.repository.User_RoleRepository;
import com.payroll.security.request.PasswordResetRequest;

@Service
public class AccessServiceImpl implements AccessService {

	@Autowired
	AccessRepository accessRepository;

	@Autowired
	PermissionRepository permissionRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RolePermissionRepository rolePermissionRepository;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	User_RoleRepository userRoleRepository;


	public Resource addResource(Resource resource) {

		return accessRepository.save(resource) ;
	}

	public RolePermission grantPermissions(RolePermission rolePermission) {

		return permissionRepository.save(rolePermission);

	}


	public Role addRole(Role role) {

		return roleRepository.save(role) ;
	}

	@Override
	public List<RolePermission> getPermissionsByRoleId(int roleId) {

		return permissionRepository.findByroleId( roleId);
	}


	@Override
	public Role getRoleByRoleID(int roleID) {

		return roleRepository.findByroleID(roleID);
	}


	@Override
	public Role getByRoleName(String roleName) {

		return roleRepository.findByroleName(roleName);
	}

	@Override
	public String updatepermissionsByRoleIDAndResourceId(ResourcePerm resourcePerm) {

		Role role=getByRoleName(resourcePerm.getRoleName());

		System.out.println(resourcePerm.getPermissionList());

		for(RolePermission p:resourcePerm.getPermissionList()) {

			p.setRoleId(role.getRoleID());
		}

		System.out.println(resourcePerm);

		for(RolePermission p:resourcePerm.getPermissionList()) {

			RolePermission rp=permissionRepository.findByRoleIdAndResourceId(p.getRoleId(),p.getResourceId());

			rp.setCanView(p.isCanView());
			rp.setCanEdit(p.isCanEdit());
			rp.setCanAdd(p.isCanAdd());
			rp.setCanDelete(p.isCanDelete());
			System.out.println(rp);
			permissionRepository.save(rp);

		}
		return "success";
	}
	
	@Override
	public User getByEmailId(String emailId) {
		// TODO Auto-generated method stub
		User user = userRepository.findByEmailId(emailId);
		return user;
	}
	
	
	


	@Override
	public String resetPasswordById(String id,PasswordResetRequest passwordResetRequest) throws Exception {
		Optional<User> mydata=userRepository.findById(id);
		if(mydata.isPresent()) {

			if(encoder.matches(passwordResetRequest.getOldPassword(), mydata.get().getPassword())) {
				User user = new User(id,mydata.get().getName(),mydata.get().getEmailId(),mydata.get().getMobile(),mydata.get().getGender(),encoder.encode(passwordResetRequest.getNewPassword()));
				userRepository.save(user);
				return "password set succesfully";
			}
			else {
				throw new Exception("previous password not matched");
			}
			
			
		}else {
			throw new Exception("data not found");
		}
	}

	@Override
	public String deleteResource(int id) {
		accessRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public String deleteRole(int id) {
		roleRepository.deleteById(id);
		return "Deleted role";
	}

	@Override
	public String setRole(User_Role userRole) {
		userRoleRepository.save(userRole);
		return "Updated";
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public String deleteRoleById(int roleId) {
		// TODO Auto-generated method stub
		rolePermissionRepository.deleteById(roleId);
		 
		 return "Deleted Role";
		
	}
	public List<User> getAllUsers() {
		return userRepository.findAll();
		}

}

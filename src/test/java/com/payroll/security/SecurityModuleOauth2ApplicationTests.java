package com.payroll.security;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.payroll.security.model.Resource;
import com.payroll.security.model.Role;
import com.payroll.security.model.User;
import com.payroll.security.repository.AccessRepository;
import com.payroll.security.repository.RoleRepository;
import com.payroll.security.repository.UserRepository;
import com.payroll.security.service.AccessService;
import com.sun.el.stream.Optional;


@RunWith(SpringRunner.class)

@SpringBootTest
class SecurityModuleOauth2ApplicationTests {
	
	@Autowired
	AccessService accessService;
	
	
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private RoleRepository roleRepository;
	@MockBean
	private AccessRepository accessRepository;
	
	@Test
	public void getAllUsersTest() {
		
		when(userRepository.findAll())
			.thenReturn(Stream.of(new User("21","yash","yash@gmail.com","0000","male","66000","password")).collect(Collectors.toList()));
		
				
		assertEquals(1,accessService.getAllUsers().size());
	}
	
	@Test
	public void getAllRolesTest() {
		
		when(roleRepository.findAll())
			.thenReturn(Stream.of(new Role(1,"super_Admin")).collect(Collectors.toList()));
		
				
		assertEquals(1,accessService.getAllRoles().size());
	}
	
//	@Test
//	public void addRoleTest() {
//		
//	}

	@Test
	public void addRoleTest() {
	Role role = new Role(1,"TestRole");
	
	when(roleRepository.save(role)).thenReturn(role);

	assertEquals(role,accessService.addRole(role));

	}
	@Test
	public void addResourceTest() {
	Resource resource = new Resource();
	
	when(accessRepository.save(resource)).thenReturn(resource);

	assertEquals(resource,accessService.addResource(resource));

	}

}

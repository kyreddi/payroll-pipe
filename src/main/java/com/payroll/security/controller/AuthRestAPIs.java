package com.payroll.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.payroll.security.jwt.JwtProvider;
import com.payroll.security.model.EmailRequestDto;
import com.payroll.security.model.User;
import com.payroll.security.model.User_Role;
import com.payroll.security.repository.UserRepository;
import com.payroll.security.repository.User_RoleRepository;
import com.payroll.security.request.LoginForm;
import com.payroll.security.request.PasswordResetRequest;
import com.payroll.security.request.SignUpForm;
import com.payroll.security.response.JwtResponse;
import com.payroll.security.response.ResponseMessage;
import com.payroll.security.service.AccessServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")


public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AccessServiceImpl accessAervice;
	
	@Autowired
	User_RoleRepository userRoleRepository;

	EmailRequestDto email = null;
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		System.out.println(loginRequest.getUsername());
		System.out.println(loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		User data=accessAervice.getByEmailId(loginRequest.getUsername());
		

		return ResponseEntity.ok(new JwtResponse(data.getId(),data.getName(),jwt, userDetails.getUsername(),data.getMobile(),data.getGender(), userDetails.getAuthorities()));
	}
	
	
	@PutMapping("/reset/{id}")
	public String passwordReset(@PathVariable("id") String id,@RequestBody PasswordResetRequest passwordResetRequest) throws Exception {
		return accessAervice.resetPasswordById(id, passwordResetRequest);
	}
	
	
	
	//NEW USER REGISTRATION & WEBCLIENT REQUEST TO EMAIL MICROSERVICE
		@PostMapping("/signup")
		public ResponseEntity<?> registerUser(@RequestBody SignUpForm signUpRequest) {
			System.out.println(signUpRequest);
//			if (userRepository.existsByUsername(signUpRequest.getName())) {
//				return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
//						HttpStatus.BAD_REQUEST);
//			}

			if (userRepository.existsByEmailId(signUpRequest.getEmailId())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
						HttpStatus.BAD_REQUEST);
			}

			// Creating user's account
			User user = new User(signUpRequest.getName(), signUpRequest.getEmailId(),
					encoder.encode(signUpRequest.getPassword()));
			
		

			userRepository.save(user);
			
			
			//SETTING DEFAULT ROLE
			String defaultRole = "3";
			String userId = String.valueOf(user.getId());
			User_Role userRole = new User_Role(userId, defaultRole);
			userRoleRepository.save(userRole);
			
		
			
		
			return new ResponseEntity<>(user, HttpStatus.OK);
		}

	
	
	
	
	

	

}
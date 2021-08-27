package com.org.security.controller;

import java.util.HashSet;
import java.util.Set;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.security.jwt.JwtProvider;
import com.org.security.model.User;
import com.org.security.model.UserEntity;
import com.org.security.repository.UserRepository;
//import com.org.security.repository.UserRepository;
import com.org.security.request.LoginForm;
import com.org.security.request.SignUpForm;
import com.org.security.response.JwtResponse;
import com.org.security.response.ResponseMessage;
import com.org.security.service.AccessServiceImpl;
//import com.org.security.message.response.ResponseMessage;
import com.org.security.model.UserEntity;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;
//	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AccessServiceImpl accessServiceImpl;
	
	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		System.out.println(loginRequest.getUsername());
		System.out.println(loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> userReg(@Valid @RequestBody SignUpForm signupRequest){
		
		if(userRepository.existsByEmailId(signupRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail user name already exist"), HttpStatus.BAD_REQUEST);
		}
		
		User user = new User(signupRequest.getName(), signupRequest.getEmail(),encoder.encode(signupRequest.getPassword()));
		
		accessServiceImpl.signupUser(user);
		
		return new ResponseEntity<>(new ResponseMessage("successfull"), HttpStatus.OK);
	}

}
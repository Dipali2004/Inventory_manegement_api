package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.SignUpDTO;
import com.rt.serviceInterfase.SignUpInterface;

@RestController
@RequestMapping("/main")
public class SignUpController {
	@Autowired
	private SignUpInterface signUpInterface;
	
@PostMapping("/SignUp")
	public boolean signup(@RequestBody SignUpDTO signUpDTO ) {
		
	boolean userStatus=signUpInterface.signUp(signUpDTO);
	return userStatus;
	}
	
}

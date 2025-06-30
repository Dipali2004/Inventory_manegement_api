
package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.rt.DTO.LoginDTO;
import com.rt.DTO.RespLoginDTO;
import com.rt.serviceInterfase.LoginInterface;


@RestController

@RequestMapping("/api")
public class HomeController {

	@Autowired
	private LoginInterface loginInterface;

	@PostMapping("/login")
	public RespLoginDTO addProduct(@RequestBody LoginDTO loginDto) {
		
		RespLoginDTO data=	loginInterface.login(loginDto);
		return data;

	}


  

}

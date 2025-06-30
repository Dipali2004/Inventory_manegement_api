
package com.rt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.rt.DTO.LoginDTO;
import com.rt.DTO.RespLoginDTO;
import com.rt.repository.LoginRepository;
import com.rt.serviceInterfase.LoginInterface;

@Service
public class ServiceImplementation implements LoginInterface {

	@Autowired
	private LoginRepository loginRepository;
	
//	@Autowired
//	private LoginMapper loginMapper;

	@Override
	public RespLoginDTO login(LoginDTO loginDto) {
		System.out.println("boot service loginDTO: " + loginDto.getEmail());

		// Get the user entity based on email and password
		RespLoginDTO respLoginDTO = loginRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());

		// Null check before mapping
		if (respLoginDTO != null) {
			System.out.println("Boot service");
			System.out.println("Boot service :"+respLoginDTO.getRole());
		return respLoginDTO;
		}
		return null;
	}
}


package com.rt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.SignUpDTO;
import com.rt.entity.SignUpEntity;
import com.rt.mapper.SignUpMapper;
import com.rt.repository.SignUp;
import com.rt.serviceInterfase.SignUpInterface;

@Service
public class SignUpImplementation implements SignUpInterface {

	@Autowired
	private  SignUp signUpRespo;
	
	@Autowired
	private SignUpMapper signUpMapper;
	@Override
	public boolean signUp(SignUpDTO signUpDTO) {
		
		SignUpEntity signUpEntity = signUpMapper.toEntity(signUpDTO);
		SignUpEntity user=signUpRespo.save(signUpEntity);
		if(user!=null) {
			return true;
		}
		return false;
		
	}
}

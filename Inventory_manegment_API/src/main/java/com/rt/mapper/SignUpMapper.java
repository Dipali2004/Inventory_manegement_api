package com.rt.mapper;

import org.springframework.stereotype.Component;


import com.rt.DTO.SignUpDTO;
import com.rt.entity.SignUpEntity;

@Component
public class SignUpMapper {

	public  SignUpDTO toDTO ( SignUpEntity signUpEntity ) {
		
		SignUpDTO dto = new SignUpDTO(signUpEntity.getId(),  signUpEntity.getFullName(), signUpEntity.getEmail(), signUpEntity.getPhone(), signUpEntity.getPassword(), signUpEntity.getRole());
		return dto;
		
		
	}
	
	public  SignUpEntity toEntity(SignUpDTO signUpDTO) {
		SignUpEntity entity  = new SignUpEntity(signUpDTO.getId(), signUpDTO.getFullName(), signUpDTO.getEmail(), signUpDTO.getPhone(), signUpDTO.getPassword(), signUpDTO.getRole());
		return entity;
		
		
	}
}

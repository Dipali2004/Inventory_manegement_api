package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.DTO.LoginDTO;
import com.rt.DTO.RespLoginDTO;
import com.rt.entity.SignUpEntity;

@Component
public class LoginMapper {
	
public  RespLoginDTO toDTO ( SignUpEntity signUpEntity ) {

	RespLoginDTO dto = new RespLoginDTO();
	dto.setId(signUpEntity.getId());
	dto.setEmail(signUpEntity.getEmail());
	dto.setRole(signUpEntity.getRole());
		return dto;
		
		
	}
	
	public  SignUpEntity toEntity(LoginDTO loginDTO) {
		SignUpEntity entity  = new SignUpEntity();
		entity.setId(loginDTO.getId());
		entity.setEmail(loginDTO.getEmail());
		entity.setPassword(loginDTO.getPassword());
		entity.setRole(loginDTO.getRole());
		return entity;
		
		
	}

}

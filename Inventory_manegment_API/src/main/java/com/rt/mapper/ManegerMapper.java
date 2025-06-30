package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.DTO.GetAllManegerDTO;
import com.rt.DTO.ManegerDTO;
import com.rt.entity.Maneger;

@Component
public class ManegerMapper {

	public  ManegerDTO toDto(Maneger maneger) {
		ManegerDTO dto = new ManegerDTO(maneger.getId(), maneger.getFullName(), maneger.getEmail(), maneger.getPhone(), maneger.getPassword(), maneger.getRole() ,maneger.getAddress(),maneger.getUser() );
		return dto;
	}
	
	public  Maneger toEntiy(ManegerDTO manegerDTO) {
		Maneger entity = new Maneger(manegerDTO.getId(), manegerDTO.getFullName(), manegerDTO.getEmail(), manegerDTO.getPhone(), manegerDTO.getPassword(), manegerDTO.getRole(), manegerDTO.getAddress(), manegerDTO.getUser());
		
		return entity;
		
	}
	
//	 get all records
	public  GetAllManegerDTO toDtoGet(Maneger maneger) {
		GetAllManegerDTO dto = new GetAllManegerDTO(maneger.getId(), maneger.getFullName(), maneger.getEmail(), maneger.getPhone(), maneger.getPassword(), maneger.getRole() ,maneger.getAddress(),maneger.getUser() );
		return dto;
	}
	
	public  Maneger toEntiyGet(GetAllManegerDTO getAllManegerDTO) {
		Maneger entity = new Maneger(getAllManegerDTO.getId(), getAllManegerDTO.getFullName(), getAllManegerDTO.getEmail(), getAllManegerDTO.getPhone(), getAllManegerDTO.getPassword(), getAllManegerDTO.getRole(), getAllManegerDTO.getAddress(), getAllManegerDTO.getUser());
		
		return entity;
		
	}


	
	//  update records
	
 
	
	

	
}

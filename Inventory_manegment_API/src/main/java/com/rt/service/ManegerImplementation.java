package com.rt.service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rt.DTO.GetAllManegerDTO;
import com.rt.DTO.ManegerDTO;
import com.rt.entity.Maneger;
import com.rt.mapper.ManegerMapper;
import com.rt.repository.ManegerInt;
import com.rt.serviceInterfase.ManegerInterface;

@Service
public class ManegerImplementation<GetAllManeger> implements ManegerInterface {
	@Autowired
	private ManegerInt manegerInt;

	@Autowired
	private ManegerMapper manegerMapper;

	@Override
	public ManegerDTO addManger(ManegerDTO manegerDTO) {
		System.out.println("boot service ");

		Maneger addManeger = manegerMapper.toEntiy(manegerDTO);

		Maneger maneger = manegerInt.save(addManeger);

		ManegerDTO data = manegerMapper.toDto(maneger);

		System.out.println("data get successfully");

		return data;
	}

	@Override
	public List<GetAllManegerDTO> getAll() {

		List<Maneger> allManager = manegerInt.findAll();

		List<GetAllManegerDTO> dtoList = new ArrayList<>();
		for (Maneger manger : allManager) {
			GetAllManegerDTO dto = manegerMapper.toDtoGet(manger);
			System.out.println(dto.getFullName());
			System.out.println(dto.getEmail());
			System.out.println(dto.getPhone());
			System.out.println(dto.getPassword());
			System.out.println(dto.getRole());
			System.out.println(dto.getAddress());

			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public GetAllManegerDTO update(int id) {
		Optional<Maneger> user = manegerInt.findById(id);

		if (user.isPresent()) {
			Maneger maneger = user.get();
			GetAllManegerDTO data = manegerMapper.toDtoGet(maneger);

			return data;
		}
		return null;

	}

	@Override
	public GetAllManegerDTO update(GetAllManegerDTO getAllManegerDTO) {
		Maneger update = manegerMapper.toEntiyGet(getAllManegerDTO);

		Maneger maneger = manegerInt.save(update);

		GetAllManegerDTO data = manegerMapper.toDtoGet(maneger);

		System.out.println("data get successfully");
		return data;
	}

	

	
}

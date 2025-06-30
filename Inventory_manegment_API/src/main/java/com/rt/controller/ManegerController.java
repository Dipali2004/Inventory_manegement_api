package com.rt.controller;

import java.util.List;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.GetAllManegerDTO;
import com.rt.DTO.ManegerDTO;
import com.rt.serviceInterfase.ManegerInterface;

@RestController
@RequestMapping("/api")
public class ManegerController {

	@Autowired
	private ManegerInterface manegerInterface;

	@PostMapping("/maneger")
	public ManegerDTO addManger(@RequestBody ManegerDTO manegerDTO, HttpSession session, Model model) {

		ManegerDTO data = manegerInterface.addManger(manegerDTO);
		return data;
	}

	@GetMapping("/getAllData")
	public List<GetAllManegerDTO> getAll() {
		System.out.println("hello");

		return manegerInterface.getAll();
	}

	@GetMapping("/update/{id}")
	public GetAllManegerDTO update(@PathVariable int id,GetAllManegerDTO getAllManeger) {

		GetAllManegerDTO dto=manegerInterface.update(id);
	
		return dto;
		
	}
	
	@PostMapping("/update")
	public GetAllManegerDTO update(@RequestBody GetAllManegerDTO getAllManegerDTO) {
		
		GetAllManegerDTO data = manegerInterface.update(getAllManegerDTO);
		return data;
	}

}

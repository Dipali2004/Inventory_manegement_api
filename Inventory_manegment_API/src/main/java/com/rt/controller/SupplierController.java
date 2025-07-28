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

import com.rt.DTO.SupplierDTO;
import com.rt.DTO.SupplierRespDTO;
import com.rt.serviceInterfase.SupplierInterface;

@RestController
@RequestMapping("/api1")

public class SupplierController {
	@Autowired
	private SupplierInterface supplierInterface;

	@PostMapping("/add")
	public SupplierRespDTO add(@RequestBody SupplierDTO supplierDTO, HttpSession session, Model model) {
		SupplierRespDTO data = supplierInterface.add(supplierDTO);
		return data;

	}

	@GetMapping("/get")
	public List<SupplierRespDTO> getAll() {
		
		return supplierInterface.getAll();
	}

	@GetMapping("/update/{id}")
	public Object GetAll(@PathVariable int id) {
		return supplierInterface.GetAll(id);

	}

	@PostMapping("/updateForm")
	public SupplierRespDTO updateForm(@RequestBody SupplierDTO supplierDTO) {
		SupplierRespDTO data = supplierInterface.updateForm(supplierDTO);
		System.out.println(data.getSupplierId());

		return data;
	}

}

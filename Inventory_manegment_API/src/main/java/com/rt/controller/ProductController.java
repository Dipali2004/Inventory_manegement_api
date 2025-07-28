
package com.rt.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.SupplierRespDTO;
import com.rt.serviceInterfase.ProductInterface;

@RequestMapping("/product")
@RestController
public class ProductController {
	@Autowired
	private ProductInterface productInterface;

	@GetMapping("/supplier")
	public List<SupplierRespDTO> supplier() {
		return productInterface.supplier();
	}

	@PostMapping("/add")
	public ProductRespDto addProduct(@Valid @RequestBody ProductDTO productDTO, BindingResult result, Model model,
			HttpSession session) {

		return productInterface.addProduct(productDTO);

	}

	@GetMapping("/getall")
	public List<ProductRespDto> getall() {
		return productInterface.getall();
	}

	@GetMapping("/update/{id}")
	public Object update(@PathVariable int id) {
		return productInterface.update(id);

	}

	@PostMapping("/updateform")
	public void updateForm(@RequestBody ProductDTO productDTO) {

		productInterface.updateForm(productDTO);

	}
}
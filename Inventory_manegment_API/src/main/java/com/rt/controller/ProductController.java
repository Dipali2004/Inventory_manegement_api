
package com.rt.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		String userEmail = (String) session.getAttribute("userEmail");
		 productDTO.setUser(userEmail);
		System.out.println(userEmail);
		return productInterface.addProduct(productDTO);

	}

//	@GetMapping("/getall")
//	public List<ProductRespDto> getall(@RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size) {
//		return productInterface.getall(page,size);
//	}
	
	@GetMapping("/getall")
	public Page<ProductRespDto> getall(@RequestParam(defaultValue = "0") int page,
	                                   @RequestParam(defaultValue = "4") int size) {
	    return productInterface.getall(page, size);
	}


	@GetMapping("/update/{id}")
	public Object update(@PathVariable int id) {
		return productInterface.update(id);

	}

	@PostMapping("/updateform")
	public void updateForm(@RequestBody ProductDTO productDTO) {

		productInterface.updateForm(productDTO);

	}
	
	 @DeleteMapping("/delete/{id}")
	    public String softDelete(@PathVariable int id) {
		 productInterface.softDelete(id);
	        return "Product ID " + id + " marked as INACTIVE";
	    }
}
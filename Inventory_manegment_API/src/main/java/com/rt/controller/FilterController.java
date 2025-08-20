package com.rt.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.mapper.ProductMapper;
import com.rt.serviceInterfase.FilterInterface;

@RestController
@RequestMapping("/filter2")
public class FilterController {

	@Autowired
	private FilterInterface filterInterface;

	@Autowired
	private ProductMapper productMapper;

	@GetMapping("/Inventory")
	public List<ProductRespDto> getallInventory() {
		return filterInterface.getallInventory();
	}

	@GetMapping("/filterData")
	@CrossOrigin(origins = "http://localhost:8012")
	public List<ProductDTO> search(@RequestParam String filterType, @RequestParam(required = false) String name) {
		System.out.println(filterType);
		System.out.println(name);
		

		if ("product".equalsIgnoreCase(filterType)) {
			return filterInterface.searchProducts(name)
					.stream()
					.map(product -> new ProductDTO(
					        product.getProductId(), 
					        product.getProductName(),
					        product.getCategory(),
					        product.getSupplierId(),
					        product.getSupplierName(),
					        product.getQuantityInStock(),
					        product.getReorderLevel(),
					        product.getPricePerUnit(),
					        null
					))
                        .collect(Collectors.toList());
		} else if ("supplier".equalsIgnoreCase(filterType)) {
			return filterInterface.searchSuppliers(name);
		} else {

			return Collections.emptyList();
		}
	}

}

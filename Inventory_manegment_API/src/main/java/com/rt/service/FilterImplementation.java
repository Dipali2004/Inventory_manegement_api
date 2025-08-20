package com.rt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.entity.Product;
import com.rt.mapper.ProductMapper;
import com.rt.repository.FilterRepository;
import com.rt.repository.ProductRepo;
import com.rt.serviceInterfase.FilterInterface;

@Service
public class FilterImplementation implements FilterInterface {
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private FilterRepository filterRepository;

	@Override
	public List<ProductDTO> search(String name) {

		return filterRepository.searchProductNames(name);
	}

	@Override
	public List<ProductDTO> searchProducts(String name) {

		return filterRepository.searchProductNames(name);
	}

	@Override
	public List<ProductDTO> searchSuppliers(String name) {
		// TODO Auto-generated method stub
		return filterRepository.searchSupplierNames(name);
	}

	@Override
	public List<ProductRespDto> getallInventory() {
	    List<Product> getAll = productRepo.findAll();

	    List<ProductRespDto> dto = new ArrayList<>();
	    for (Product product : getAll) {
	        ProductRespDto data = productMapper.toDto(product);
	        System.out.println(data);
	        dto.add(data);
	    }
	    return dto;
	}


}

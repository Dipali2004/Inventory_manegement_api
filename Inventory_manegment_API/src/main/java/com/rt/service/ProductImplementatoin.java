package com.rt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.ProductUpdate;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Product;
import com.rt.entity.Supplier;
import com.rt.mapper.ProductMapper;
import com.rt.mapper.SupplierMapper;
import com.rt.repository.ProductRepo;
import com.rt.repository.SupplierRepo;
import com.rt.serviceInterfase.ProductInterface;
@Service
public class ProductImplementatoin implements ProductInterface {


	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private SupplierRepo supplierRepo;
	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public ProductRespDto addProduct(ProductDTO productDTO) {
		int supplierId = productDTO.getSupplierId();

		Supplier supplier = supplierRepo.findById(supplierId)
				.orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + supplierId));
		System.out.println(productDTO.getSupplierName());
		Product product = productMapper.toEntity(productDTO, supplier);
		Product data = productRepo.save(product);
		ProductRespDto dto = productMapper.toDto(data);

		return dto;
	}

	@Override
	public List<SupplierRespDTO> supplier() {
		List<Supplier> suppliers = supplierRepo.findAll();
		List<SupplierRespDTO> dtoList = new ArrayList<>();

		for (Supplier supplier : suppliers) {
			SupplierRespDTO dto = supplierMapper.toDto(supplier);
			dtoList.add(dto);
		}

		return dtoList;

	}

	@Override
	public List<ProductRespDto> getall() {
		List<Product> getAll = productRepo.findAll();

		List<ProductRespDto> dto = new ArrayList<>();
		for (Product product : getAll) {
			ProductRespDto data = productMapper.toDto(product);
			System.out.println(data);
			dto.add(data);
		}
		return dto;
	}

	@Override
	public Object update(int id) {
		Optional<Product> product = productRepo.findById(id);
		if (product.isPresent()) {
			Product data = product.get();
			ProductRespDto info = productMapper.toDto(data);
			return info;
		}
		return null;
	}
//	@Override
//	public ProductRespDto updateForm(ProductUpdate productUpdate) {
//	    Product product = productMapper.toEntityUpdate(productUpdate);
//	    Product data = productRepo.save(product);
//	    return productMapper.toDto(data);
//	}
	@Override
	public ProductRespDto updateForm(ProductDTO productDTO) {
		 Product existing = productRepo.findById(productDTO.getProductId())
			        .orElseThrow(() -> new RuntimeException("Product not found"));

			    existing.setProductName(productDTO.getProductName());
			    existing.setCategory(productDTO.getCategory());
			    existing.setQuantityInStock(productDTO.getQuantityInStock());
			    existing.setReorderLevel(productDTO.getReorderLevel());
			    existing.setPricePerUnit(productDTO.getPricePerUnit());

			    // ❌ Do not touch supplier

			    Product updated = productRepo.save(existing);

			    return productMapper.toDto(updated);

	}

	@Override
	public ProductRespDto updateForm(ProductUpdate productUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

}

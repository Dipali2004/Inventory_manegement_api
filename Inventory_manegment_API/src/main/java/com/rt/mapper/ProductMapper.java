package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.ProductUpdate;
import com.rt.entity.Product;
import com.rt.entity.Supplier;

@Component
public class ProductMapper {

	public ProductRespDto toDto(Product product) {
		ProductRespDto dto = new ProductRespDto();
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setCategory(product.getCategory());
		dto.setQuantityInStock(product.getQuantityInStock());
		dto.setReorderLevel(product.getReorderLevel());
		dto.setPricePerUnit(product.getPricePerUnit());

		dto.setSupplierId(product.getSupplier().getSupplierId()); // or getId()
		dto.setSupplierName(product.getSupplier().getName());

		return dto;
	}

	// Convert DTO → Entity
	public Product toEntity(ProductDTO dto, Supplier supplier) {
		Product product = new Product();
		product.setProductId(dto.getProductId());
		product.setProductName(dto.getProductName());
		product.setCategory(dto.getCategory());
		product.setQuantityInStock(dto.getQuantityInStock());
		product.setReorderLevel(dto.getReorderLevel());
		product.setPricePerUnit(dto.getPricePerUnit());

		supplier.setUser(dto.getUser());
		product.setSupplier(supplier);

		return product;
	}

	public Product toEntityUpdate(ProductUpdate dto) {
		Product product = new Product();
		product.setProductId(dto.getProductId());
		product.setProductName(dto.getProductName());
		product.setCategory(dto.getCategory());
		product.setQuantityInStock(dto.getQuantityInStock());
		product.setReorderLevel(dto.getReorderLevel());
		product.setPricePerUnit(dto.getPricePerUnit());
		// supplier not set here intentionally
		return product;
	}

	// Entity to DTO
	public ProductUpdate toDtoUpdate(Product product) {
		ProductUpdate dto = new ProductUpdate();
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setCategory(product.getCategory());
		dto.setQuantityInStock(product.getQuantityInStock());
		dto.setReorderLevel(product.getReorderLevel());
		dto.setPricePerUnit(product.getPricePerUnit());
		// supplier not included here
		return dto;
	}

}

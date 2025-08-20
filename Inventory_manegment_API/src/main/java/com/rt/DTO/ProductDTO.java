package com.rt.DTO;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private int productId;
	@NotBlank(message = "Product Name cannot be blank")
	private String productName;
	private String category;
	private int supplierId;
	private String supplierName;
	private int quantityInStock;
	private int reorderLevel;
	private double pricePerUnit;
//	@NotNull(message = "Supplier is required")
//	private Supplier supplier;

	private String User;

	public ProductDTO(int productId, String productName, int supplierId, String supplierName) {
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public ProductDTO(int productId, String productName, String category, int quantityInStock, int reorderLevel,
			double pricePerUnit) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.quantityInStock = quantityInStock;
		this.reorderLevel = reorderLevel;
		this.pricePerUnit = pricePerUnit;
	}

	public ProductDTO(int productId, String productName, String category, int supplierId, String supplierName,
			int quantityInStock, int reorderLevel, double pricePerUnit) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.quantityInStock = quantityInStock;
		this.reorderLevel = reorderLevel;
		this.pricePerUnit = pricePerUnit;
	}

}

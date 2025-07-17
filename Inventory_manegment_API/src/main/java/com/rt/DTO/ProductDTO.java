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
}

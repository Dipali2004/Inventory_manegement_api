package com.rt.DTO;


import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {


	 private int supplierId;   
	private String name;
	private  String contactInfo;
	private String address;
	private List<ProductDTO> products;
	
	private String User;
	
	
}

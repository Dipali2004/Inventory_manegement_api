package com.rt.serviceInterfase;

import java.util.List;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;


public interface FilterInterface {

//	Object filter(String name, String searchValue);

	

	List<ProductDTO> search(String name);

	List<ProductDTO> searchProducts(String name);

	List<ProductDTO> searchSuppliers(String name);

	List<ProductRespDto> getallInventory();

//	Object filter(String name, String serchValue);

}

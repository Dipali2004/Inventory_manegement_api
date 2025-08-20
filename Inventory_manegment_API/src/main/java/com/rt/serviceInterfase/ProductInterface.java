package com.rt.serviceInterfase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.ProductUpdate;
import com.rt.DTO.SupplierRespDTO;

public interface ProductInterface {

	ProductRespDto addProduct(ProductDTO productDTO);

	List<SupplierRespDTO> supplier();

//	List<ProductRespDto> getall(@RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "3") int size);

	Object update(int id);

	ProductRespDto updateForm(ProductDTO productDTO);

	ProductRespDto updateForm(ProductUpdate productUpdate);

	Page<ProductRespDto> getall(int page, int size);

	String softDelete(int id);

//	List<ProductRespDto> getall(int page, int size);

}

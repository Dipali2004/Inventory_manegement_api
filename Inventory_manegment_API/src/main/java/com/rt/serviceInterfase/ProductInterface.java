package com.rt.serviceInterfase;

import java.util.List;


import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.ProductUpdate;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Supplier;

public interface ProductInterface {

	ProductRespDto addProduct(ProductDTO productDTO);

	List<SupplierRespDTO> supplier();

	List<ProductRespDto> getall();

	Object update(int id);

	ProductRespDto updateForm(ProductDTO productDTO);

	ProductRespDto updateForm(ProductUpdate productUpdate);

}

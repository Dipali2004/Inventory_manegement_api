package com.rt.serviceInterfase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.SupplierRespDTO;

public interface PurcheseInterface {

	PurchaseRespDto add_stock(PurchaseDTO purchaseDTO);

	List<SupplierRespDTO> supplier();

	List<ProductRespDto> product();

	Page<PurchaseRespDto> getData(int page, int size);

	Object getDataID(int id);

	void update(PurchaseDTO purchaseDTO);

}

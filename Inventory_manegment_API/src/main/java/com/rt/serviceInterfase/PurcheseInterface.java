package com.rt.serviceInterfase;

import java.util.List;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.SupplierRespDTO;

public interface PurcheseInterface {

	PurchaseRespDto add_stock(PurchaseDTO purchaseDTO);

	List<SupplierRespDTO> supplier();

	List<ProductRespDto> product();

	List<PurchaseRespDto> getData();

	Object getDataID(int id);

	void update(PurchaseDTO purchaseDTO);

}

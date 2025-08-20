package com.rt.serviceInterfase;

import java.time.LocalDate;
import java.util.List;

import com.rt.DTO.ProductReoprtDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.StockOutRepDTO;
import com.rt.DTO.SupplierRespDTO;

public interface ReportInterface {

	List<ProductReoprtDTO> StockReport();

	Object lowStock();

	List<PurchaseRespDto> purchaseReport();

	List<ProductRespDto> product();

	List<SupplierRespDTO> supplier();

	List<ProductReoprtDTO> search(LocalDate date, String name);

	List<StockOutRepDTO> saleReport();


//	List<StockOutRepDTO> serchSale(String productName, LocalDate startDate, LocalDate endDate);

	List<String> serchSale(String keyword);

	List<StockOutRepDTO> filter(String productName);



}

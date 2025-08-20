package com.rt.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.ProductReoprtDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.StockOutRepDTO;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Product;
import com.rt.entity.Purchase;
import com.rt.entity.StockOut;
import com.rt.entity.Supplier;
import com.rt.mapper.ProductMapper;
import com.rt.mapper.PurchaseMapper;
import com.rt.mapper.StockOutMapper;
import com.rt.mapper.SupplierMapper;
import com.rt.repository.ProductRepo;
import com.rt.repository.PurcheseRepo;
import com.rt.repository.ReportRepo;
import com.rt.repository.StockOutRepo;
import com.rt.repository.SupplierRepo;
import com.rt.serviceInterfase.ReportInterface;

@Service
public class ReportImplementation implements ReportInterface {
	@Autowired
	private ReportRepo reportRepo;
	@Autowired
	private PurcheseRepo purcheseRepo;
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private SupplierRepo supplierRepo;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private PurchaseMapper purchaseMapper;

	@Autowired
	private StockOutRepo stockOutRepo;
	@Autowired
	private StockOutMapper stockOutMapper;
	@Override
	public List<ProductReoprtDTO> StockReport() {
		return reportRepo.getProductReport();

	}

	@Override
	public Object lowStock() {

		return reportRepo.getLowStockReport();
	}

//	for the purchase report
	@Override
	public List<PurchaseRespDto> purchaseReport() {
		List<Purchase> product = purcheseRepo.findAll();
		List<PurchaseRespDto> dto = new ArrayList<>();
		for (Purchase products : product) {
			PurchaseRespDto dtoList = purchaseMapper.toDto(products);
			dto.add(dtoList);
		}
		return dto;
	}

	@Override
	public List<ProductRespDto> product() {
		List<Product> product = productRepo.findAll();
		List<ProductRespDto> dto = new ArrayList<>();
		for (Product products : product) {
			ProductRespDto dtoList = productMapper.toDto(products);
			dto.add(dtoList);
		}

		return dto;

	}

	@Override
	public List<SupplierRespDTO> supplier() {
		List<Supplier> suppliers = supplierRepo.findAll();
		List<SupplierRespDTO> dtoList = new ArrayList<>();

		for (Supplier supplier : suppliers) {
			SupplierRespDTO dto = supplierMapper.toDto(supplier);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public List<ProductReoprtDTO> search(LocalDate date, String name) {
	
		return reportRepo.getFilteredReport(date, name);
	}

	@Override
	public List<StockOutRepDTO> saleReport() {
		  List<StockOut> getall = stockOutRepo.findAll();
		    List<StockOutRepDTO> dtoList = new ArrayList<>();

		    for (StockOut data : getall) {
		        StockOutRepDTO info = stockOutMapper.toDTO(data);
		        dtoList.add(info);
		    }

		    return dtoList;
	}



//	@Override
//	public List<StockOutRepDTO> serchSale(String productName, LocalDate startDate, LocalDate endDate) {
//	    LocalDateTime startDateTime = (startDate != null) ? startDate.atStartOfDay() : null;
//	    LocalDateTime endDateTime = (endDate != null) ? endDate.atTime(23, 59, 59) : null;
//
//	    return reportRepo.filterSalesReport(productName, startDateTime, endDateTime);
//	}
	@Override
	public List<String> serchSale(String keyword) {
	    return reportRepo.searchProductNames(keyword);
	}

	@Override
	public List<StockOutRepDTO> filter(String productName) {
	    return reportRepo.filterStockOut(productName);
	}




	


}

package com.rt.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.ProductReoprtDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.StockOutRepDTO;
import com.rt.DTO.SupplierRespDTO;
import com.rt.serviceInterfase.ReportInterface;

@RestController
@RequestMapping("/report")
public class ReportController {
	@Autowired
	private ReportInterface reportInterface;

	@GetMapping("/stockReport")
	public List<ProductReoprtDTO> StockReport() {
		return reportInterface.StockReport();
	}

//	    low stock report

	@GetMapping("/getData")
	public Object lowStock() {
		return reportInterface.lowStock();
	}

//	    for getting the report of the purchase

	@GetMapping("/supplierPurchaseReport")
	public List<SupplierRespDTO> supplier() {
		return reportInterface.supplier();
	}

	@GetMapping("/productPurchaseReport")
	public List<ProductRespDto> product() {
		return reportInterface.product();

	}

	@GetMapping("/purchaseReport")
	public List<PurchaseRespDto> purchaseReport() {
		return reportInterface.purchaseReport();

	}

	@GetMapping("/filterPurchase")
	@CrossOrigin(origins = "http://localhost:8012")
	public List<ProductReoprtDTO> search(
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@RequestParam(required = false) String name) {

		return reportInterface.search(date, name);
	}

//	sale report
	
	@GetMapping("/getSale")
	public List<StockOutRepDTO> saleReport() {
		return reportInterface.saleReport();
	}

	@CrossOrigin(origins = "http://localhost:8012")
	@GetMapping("/productSearch")
	public List<String> serchSale(@RequestParam String keyword) {
		return reportInterface.serchSale(keyword);
	}
	@CrossOrigin(origins = "http://localhost:8012")
	@GetMapping("/filterStockOut")
	public List<StockOutRepDTO> filter(@RequestParam String productName) {
		 System.out.println("Received Product Name: " + productName);

		    List<StockOutRepDTO> result = reportInterface.filter(productName);
		    System.out.println("Filtered Data Count: " + result.size());
		    result.forEach(System.out::println); 

		    return result;
	}
}

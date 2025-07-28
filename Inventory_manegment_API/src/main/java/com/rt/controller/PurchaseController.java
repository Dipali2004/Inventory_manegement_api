package com.rt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.SupplierRespDTO;
import com.rt.serviceInterfase.PurcheseInterface;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurcheseInterface purcheseInterface;

	@GetMapping("/supplierPurchase")
	public List<SupplierRespDTO> supplier() {
		return purcheseInterface.supplier();
	}

	@GetMapping("/productPurchase")
	public List<ProductRespDto> product() {
		return purcheseInterface.product();

	}

	@PostMapping("/add")
	public PurchaseRespDto add_stock(@RequestBody PurchaseDTO purchaseDTO) {
		return purcheseInterface.add_stock(purchaseDTO);
	}

	@GetMapping("/getallPurchase")
	public List<PurchaseRespDto> getData() {
		return purcheseInterface.getData();
	}
	@GetMapping("/getFormId/{id}")
	public Object getDataID(@PathVariable int id) {
	return	purcheseInterface.getDataID(id);
	}
	
	@PostMapping("/updatePurchase")
	public void update(@RequestBody PurchaseDTO PurchaseDTO ) {
		
		purcheseInterface.update(PurchaseDTO);
	}
	

}

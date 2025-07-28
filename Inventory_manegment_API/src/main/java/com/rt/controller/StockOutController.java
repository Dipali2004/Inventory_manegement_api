package com.rt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.StockOutDTO;
import com.rt.DTO.StockOutRepDTO;
import com.rt.serviceInterfase.StockOutInterface;

@RestController
@RequestMapping("/stock")
public class StockOutController {

	@Autowired
	private StockOutInterface stockOutInterface;

	@GetMapping("/productPurchase")
	public List<ProductRespDto> product() {
		return stockOutInterface.product();

	}

	@PostMapping("/add")
	public String add(@RequestBody StockOutDTO stockOutDTO) {

		Integer userId = stockOutDTO.getCreatedBy();
		if (userId == null) {
			throw new RuntimeException("User not logged in");
		}

		return stockOutInterface.add(stockOutDTO);
	}

	@GetMapping("/getallStock")
	public List<StockOutRepDTO> getAll() {
		return stockOutInterface.getAll();
	}

	@GetMapping("/GetId/{id}")
	public StockOutRepDTO update(@PathVariable int id) {
		return stockOutInterface.update(id);

	}
	@PostMapping("/UpdateStock")
	public void updateStock(@RequestBody StockOutDTO stockOutDTO ) {
		stockOutInterface.updateStock(stockOutDTO);
	}
}

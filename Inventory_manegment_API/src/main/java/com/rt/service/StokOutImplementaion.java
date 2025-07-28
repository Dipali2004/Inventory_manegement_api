package com.rt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.StockOutDTO;
import com.rt.DTO.StockOutRepDTO;
import com.rt.entity.Product;
import com.rt.entity.SignUpEntity;
import com.rt.entity.StockOut;
import com.rt.mapper.ProductMapper;
import com.rt.mapper.StockOutMapper;
import com.rt.repository.ProductRepo;
import com.rt.repository.SignUp;
import com.rt.repository.StockOutRepo;
import com.rt.serviceInterfase.StockOutInterface;
@Service
public class StokOutImplementaion implements StockOutInterface {
@Autowired
private StockOutRepo stockOutRepo;
@Autowired
private ProductRepo productRepo;
@Autowired
private StockOutMapper stockOutMapper;
@Autowired
private SignUp signUp;
@Autowired
private ProductMapper productMapper;

@Override
public String add(StockOutDTO stockOutDTO) {

 
    Product product = productRepo.findById(stockOutDTO.getProductId())
            .orElseThrow(() -> new RuntimeException("Product not found with ID: " + stockOutDTO.getProductId()));

  
    SignUpEntity signUpEntity = signUp.findById(stockOutDTO.getCreatedBy())
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + stockOutDTO.getCreatedBy()));

   
    StockOut stockOut = stockOutMapper.toEntity(stockOutDTO, product, signUpEntity);

   
    stockOutRepo.save(stockOut);

 
    return "Stock Out added successfully for product ID: " + stockOutDTO.getProductId();
}
@Override
public List<StockOutRepDTO> getAll() {
    List<StockOut> getall = stockOutRepo.findAll();
    List<StockOutRepDTO> dtoList = new ArrayList<>();

    for (StockOut data : getall) {
        StockOutRepDTO info = stockOutMapper.toDTO(data);
        dtoList.add(info);
    }

    return dtoList;
}
@Override
public StockOutRepDTO update(int id) {
	Optional<StockOut> product = stockOutRepo.findById(id);
	if (product.isPresent()) {
		StockOut data = product.get();
		StockOutRepDTO info = stockOutMapper.toDTO(data);
		return info;
	}
	return null;
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
public StockOutRepDTO updateStock(StockOutDTO stockOutDTO) {

  
    StockOut existingStockOut = stockOutRepo.findById(stockOutDTO.getStockOutId())
            .orElseThrow(() -> new RuntimeException("StockOut record not found"));


    Product existing = productRepo.findById(stockOutDTO.getProductId())
	        .orElseThrow(() -> new RuntimeException("Product not found"));
   
    existing.setQuantityInStock(existing.getQuantityInStock() + existingStockOut.getQuantitySold());

   
    int updatedStock = existing.getQuantityInStock() - stockOutDTO.getQuantitySold();
    if (updatedStock < 0) {
        throw new RuntimeException("Not enough stock available");
    }
    existing.setQuantityInStock(updatedStock);

   
    productRepo.save(existing);


    existingStockOut.setQuantitySold(stockOutDTO.getQuantitySold());
    existingStockOut.setCustomerName(stockOutDTO.getCustomerName());
    existingStockOut.setSaleDate(stockOutDTO.getSaleDate());

    StockOut updated = stockOutRepo.save(existingStockOut);

  
    return stockOutMapper.toDTO(updated);
}

}

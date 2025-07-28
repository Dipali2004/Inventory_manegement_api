package com.rt.mapper;

import org.springframework.stereotype.Component;
import com.rt.DTO.StockOutDTO;
import com.rt.DTO.StockOutRepDTO;
import com.rt.entity.Product;
import com.rt.entity.SignUpEntity;
import com.rt.entity.StockOut;

@Component
public class StockOutMapper {

    public static StockOutRepDTO toDTO(StockOut stockOut) {
        StockOutRepDTO dto = new StockOutRepDTO();
        dto.setStockOutId(stockOut.getStockOutId());
        dto.setQuantitySold(stockOut.getQuantitySold());
        dto.setSaleDate(stockOut.getSaleDate());
        dto.setCustomerName(stockOut.getCustomerName());

  
        if (stockOut.getProduct() != null) {
            dto.setProductId(stockOut.getProduct().getProductId());
            dto.setProductName(stockOut.getProduct().getProductName());
        }

      
        if (stockOut.getCreatedBy() != null) {
            dto.setCreatedBy(stockOut.getCreatedBy().getId());
            dto.setCreatedByName(stockOut.getCreatedBy().getFullName());
        }

        return dto;
    }

    public static StockOut toEntity(StockOutDTO dto, Product product, SignUpEntity signUpEntity) {
        StockOut stockOut = new StockOut();
        stockOut.setStockOutId(dto.getStockOutId());
        stockOut.setQuantitySold(dto.getQuantitySold());
        stockOut.setSaleDate(dto.getSaleDate());
        stockOut.setCustomerName(dto.getCustomerName());
        stockOut.setProduct(product);
        stockOut.setCreatedBy(signUpEntity);

        return stockOut;
    }
}

package com.rt.mapper;

import org.springframework.stereotype.Component;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Product;
import com.rt.entity.Purchase;
import com.rt.entity.Supplier;

@Component
public class PurchaseMapper {

    // Convert DTO to Entity
    public Purchase toEntity(PurchaseDTO dto, Product product, Supplier supplier) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(dto.getPurchaseId());
        purchase.setProduct(product);
        purchase.setSupplier(supplier);
        purchase.setQuantityPurchased(dto.getQuantityPurchased());
        purchase.setPurchaseDate(dto.getPurchaseDate());
        return purchase;
    }

    // Convert Entity to DTO
    public PurchaseRespDto toDto(Purchase purchase) {
        PurchaseRespDto dto = new PurchaseRespDto();
        dto.setPurchaseId(purchase.getPurchaseId());
        dto.setQuantityPurchased(purchase.getQuantityPurchased());
        dto.setPurchaseDate(purchase.getPurchaseDate());

        // Map product
        Product product = purchase.getProduct();
        if (product != null) {
            ProductDTO productDto = new ProductDTO();
            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            dto.setProduct(productDto);
        }

        // Map supplier
        Supplier supplier = purchase.getSupplier();
        if (supplier != null) {
        	SupplierRespDTO supplierDto = new SupplierRespDTO();
        	supplierDto.setSupplierId(supplier.getSupplierId());
        	supplierDto.setName(supplier.getName()); 
        	dto.setSupplier(supplierDto);
        }

        return dto;
    }
}

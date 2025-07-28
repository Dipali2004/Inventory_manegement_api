package com.rt.mapper;

import com.rt.DTO.ProductDTO;
import com.rt.DTO.ProductRespDto;
import com.rt.DTO.SupplierDTO;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Product;
import com.rt.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SupplierMapper {

    @Autowired
    private ProductMapper productMapper;

    // ✅ Entity to Response DTO
    public SupplierRespDTO toDto(Supplier supplier) {
        List<ProductRespDto> productDTOs = null;

        if (supplier.getProducts() != null && !supplier.getProducts().isEmpty()) {
            productDTOs = supplier.getProducts().stream()
                    .map(productMapper::toDto) // Make sure this returns ProductRespDto
                    .collect(Collectors.toList());
        }

        return new SupplierRespDTO(
                supplier.getSupplierId(),
                supplier.getName(),
                supplier.getContactInfo(),
                supplier.getAddress(),
                productDTOs,
                supplier.getUser()
                
        );
    }

    // ✅ DTO to Entity
    public Supplier toEntity(SupplierDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(dto.getSupplierId());
        supplier.setName(dto.getName());
        supplier.setContactInfo(dto.getContactInfo());
        supplier.setAddress(dto.getAddress());
        supplier.setUser(dto.getUser());

        if (dto.getProducts() != null && !dto.getProducts().isEmpty()) {
            List<Product> products = dto.getProducts().stream()
                    .map(productDTO -> {
                        Product product = productMapper.toEntity(productDTO, supplier);
                        product.setSupplier(supplier);
                        return product;
                    })
                    .collect(Collectors.toList());
            supplier.setProducts(products);
        }

        return supplier;
    }
}

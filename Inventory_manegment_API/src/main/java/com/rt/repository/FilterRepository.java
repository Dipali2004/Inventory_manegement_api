package com.rt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.DTO.ProductDTO;
import com.rt.entity.Product;

@Repository
public interface FilterRepository extends JpaRepository<Product, Integer> {

//    // Corrected: Search by Product Name
//    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :productName, '%'))")
//    List<Product> findByProductNameContainingIgnoreCase(@Param("productName") String productName);
//
//    // Correct: Search by Supplier Name

	@Query("SELECT new com.rt.DTO.ProductDTO(p.productId, p.productName, p.category, " +
		       "s.supplierId, s.name, p.quantityInStock, p.reorderLevel, p.pricePerUnit) " +
		       "FROM Product p JOIN p.supplier s " +
		       "WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
		List<ProductDTO> searchProductNames(@Param("keyword") String keyword);
	
	@Query("SELECT new com.rt.DTO.ProductDTO(p.productId, p.productName, p.category, " +
		       "s.supplierId, s.name, p.quantityInStock, p.reorderLevel, p.pricePerUnit) " +
		       "FROM Product p JOIN p.supplier s " +
		       "WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
		List<ProductDTO> searchSupplierNames(@Param("keyword") String keyword);




 
}



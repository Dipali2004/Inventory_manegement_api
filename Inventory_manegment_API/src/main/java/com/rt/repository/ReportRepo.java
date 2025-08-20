package com.rt.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rt.DTO.ProductReoprtDTO;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.StockOutRepDTO;
import com.rt.entity.Product;
@Repository
public interface ReportRepo extends JpaRepository<Product, Integer> {

    @Query("SELECT new com.rt.DTO.ProductReoprtDTO(" +
           "p.productId, p.productName, p.category, p.quantityInStock, p.reorderLevel, " +
           "CASE WHEN p.quantityInStock < p.reorderLevel THEN 'Low Stock' ELSE 'OK' END) " +
           "FROM Product p")
    List<ProductReoprtDTO> getProductReport();
    
//    for getting only the low level stock
    @Query("SELECT new com.rt.DTO.ProductReoprtDTO(" +
            "p.productId, p.productName, p.category, p.quantityInStock, p.reorderLevel, 'Low Stock') " +
            "FROM Product p " +
            "WHERE p.quantityInStock < p.reorderLevel")
     List<ProductReoprtDTO> getLowStockReport();

// for getting filterd data
    
    @Query("SELECT new com.rt.DTO.ProductReoprtDTO(" +
    	       "p.productId, p.productName, p.category, p.quantityInStock, p.reorderLevel, 'OK') " +
    	       "FROM Purchase pu " +
    	       "JOIN pu.product p " +
    	       "JOIN pu.supplier s " +
    	       "WHERE (:date IS NULL OR pu.purchaseDate = :date) " +
    	       "AND (:supplier IS NULL OR s.name LIKE CONCAT('%', :supplier, '%'))")
    	List<ProductReoprtDTO> getFilteredReport(
    	        @Param("date") LocalDate date,
    	        @Param("supplier") String supplier);
    
//    for the serch data as per the char
    
    
    @Query("SELECT p.productName FROM Product p " +
    	       "WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    	List<String> searchProductNames(@Param("keyword") String keyword);
    
//    @Query("SELECT new com.rt.DTO.StockOutRepDTO(s.stockOutId, s.quantitySold, s.saleDate, s.customerName, " +
//    	       "s.product.productId, s.product.productName, s.createdBy, s.createdByName) " +
//    	       "FROM StockOut s " +
//    	       "WHERE LOWER(s.product.productName) LIKE LOWER(CONCAT('%', :productName, '%'))")
//    	List<StockOutRepDTO> filterStockOut(@Param("productName") String productName);
    @Query("SELECT new com.rt.DTO.StockOutRepDTO(s.stockOutId, s.quantitySold, s.saleDate, s.customerName, " +
    	       "s.product.productId, s.product.productName, s.createdBy.id) " +
    	       "FROM StockOut s " +
    	       "WHERE LOWER(s.product.productName) LIKE LOWER(CONCAT('%', :productName, '%'))")
    	List<StockOutRepDTO> filterStockOut(String productName);


	
}

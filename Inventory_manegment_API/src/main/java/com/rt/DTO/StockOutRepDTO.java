package com.rt.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockOutRepDTO {
	 private int stockOutId;        
	    private Integer quantitySold;   
	    private LocalDateTime saleDate; 
	    private String customerName;  
	    private int productId; 
	    private String productName;  
	    private String createdByName;
	    private int createdBy; 

	    public StockOutRepDTO(int stockOutId, Integer quantitySold, LocalDateTime saleDate,
                String customerName, int productId, String productName, int createdById) {
this.stockOutId = stockOutId;
this.quantitySold = quantitySold;
this.saleDate = saleDate;
this.customerName = customerName;
this.productId = productId;
this.productName = productName;
this.createdBy = createdById;
}

}

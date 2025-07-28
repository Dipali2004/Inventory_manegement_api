package com.rt.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockOutDTO {

    private int stockOutId;        
    private Integer quantitySold;   
    private LocalDateTime saleDate; 
    private String customerName;  
    private int productId;         
    private int createdBy; 

}

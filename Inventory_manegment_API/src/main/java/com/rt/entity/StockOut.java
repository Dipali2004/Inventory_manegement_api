package com.rt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock_out")
public class StockOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_out_id")
    private int stockOutId;

    @Column(nullable = false)
    private Integer quantitySold;

    @Column(nullable = false)
    private LocalDateTime saleDate = LocalDateTime.now();

    @Column(name = "customer_name")
    private String customerName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false) 
    private Product product;
    // Correct join: stock_out.created_by → signup.id
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    private SignUpEntity createdBy;
   


}

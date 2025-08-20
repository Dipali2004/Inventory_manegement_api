	package com.rt.entity;
	
	import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
	import lombok.Setter;
	
	@Data
	@Entity
	@Table(name = "Product", uniqueConstraints = @UniqueConstraint(columnNames = { "productName", "supplierId" }))
	public class Product {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="productId")
		private int productId;
	
		private String productName;
	
		private String category;
	
		private int quantityInStock;
	
		private int reorderLevel;
	
		private double pricePerUnit;
	
		@ManyToOne
		@JoinColumn(name = "supplierId", nullable = false)
		private Supplier supplier;
		
		private String User;
		
		  private String status; // ACTIVE / INACTIVE

		    // getter setter
		    public void setStatus(String status) {
		        this.status = status;
		    }

		    public String getStatus() {
		        return status;
		    }
		}
	
		// Getters and Setters
	

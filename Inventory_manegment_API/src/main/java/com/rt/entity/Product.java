	package com.rt.entity;
	
	import javax.persistence.*;
	
	import lombok.Getter;
	import lombok.Setter;
	
	@Setter
	@Getter
	@Entity
	@Table(name = "Product", uniqueConstraints = @UniqueConstraint(columnNames = { "productName", "supplierId" }))
	public class Product {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
		// Getters and Setters
	}

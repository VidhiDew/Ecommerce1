package com.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	
	public Product(Long pid, String name, String description, Double price) {
		super();
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	
}

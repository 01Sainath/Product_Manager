 package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String productName;
	String description;
	int productQuantity;
	double price;
	
	@Enumerated(EnumType.STRING)
	Category category;
	
	boolean inStock;
	LocalDate productionDate;
	
	@ManyToOne
	@JoinColumn(name="provider_id")
	User provider;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public LocalDate getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}

	public User getProvider() {
		return provider;
	}

	public void setProvider(User provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description
				+ ", productQuantity=" + productQuantity + ", price=" + price + ", category=" + category + ", inStock="
				+ inStock + ", productionDate=" + productionDate + ", provider=" + provider + "]";
	}

	public Product(String productName, String description, int productQuantity, double price, Category category,
			boolean inStock, LocalDate productionDate, User provider) {
		super();
		this.productName = productName;
		this.description = description;
		this.productQuantity = productQuantity;
		this.price = price;
		this.category = category;
		this.inStock = inStock;
		this.productionDate = productionDate;
		this.provider = provider;
	}
	public Product(String productName, String description, int productQuantity, double price, Category category,
			boolean inStock, LocalDate productionDate) {
		super();
		this.productName = productName;
		this.description = description;
		this.productQuantity = productQuantity;
		this.price = price;
		this.category = category;
		this.inStock = inStock;
		this.productionDate = productionDate;
	}
	public Product() {
		
	}
	
	
}

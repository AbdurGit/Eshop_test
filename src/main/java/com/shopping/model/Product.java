package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	private String brand;
	private String specification;
	private String entryDate;

	@OneToOne
	private Price price;

	public Product(int productId, String productName, String brand, String specification, String entryDate,
			Price price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.specification = specification;
		this.entryDate = entryDate;
		this.price = price;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

}

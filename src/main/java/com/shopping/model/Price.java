package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Price {
	@Id
	private int priceId;
	private int buyingPrice;
	private int MRP;
	private int maxDiscount;
	
	
	

	public Price(int priceId, int buyingPrice, int mRP, int maxDiscount) {
		super();
		this.priceId = priceId;
		this.buyingPrice = buyingPrice;
		MRP = mRP;
		this.maxDiscount = maxDiscount;
		
	}

	public Price() {
		// TODO Auto-generated constructor stub
	}

	

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public int getMRP() {
		return MRP;
	}

	public void setMRP(int mRP) {
		MRP = mRP;
	}

	public int getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(int maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	

}

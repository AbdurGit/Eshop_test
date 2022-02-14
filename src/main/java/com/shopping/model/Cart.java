package com.shopping.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	private String cartId;
	private String cartName;
	@OneToOne
private User user;
	public Cart() {

	}
	
	public Cart(String cartId, String cartName, User user) {
		super();
		this.cartId = cartId;
		this.cartName = cartName;
		this.user = user;
	}

	public String getCartId() {
		return cartId;
	}
	public void setCartId(String string) {
		this.cartId = string;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	

}

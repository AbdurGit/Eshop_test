package com.shopping.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wishlist {
	@Id
private String wishlistId;
private String wishlistName;
@OneToOne
private User user;
public Wishlist() {
	
}


public Wishlist(String wishlistId, String wishlistName, User user) {
	super();
	this.wishlistId = wishlistId;
	this.wishlistName = wishlistName;
	this.user = user;
}


public String getWishlistId() {
	return wishlistId;
}
public void setWishlistId(String string) {
	this.wishlistId = string;
}
public String getWishlistName() {
	return wishlistName;
}
public void setWishlistName(String wishlistName) {
	this.wishlistName = wishlistName;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}


}

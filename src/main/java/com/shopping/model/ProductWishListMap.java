package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductWishListMap {
	
	@Id
private String mapId;
private String wishListId;
private String productId;


public ProductWishListMap() {

}

public ProductWishListMap(String mapId, String wishListId, String productId) {
	
	this.mapId = mapId;
	this.wishListId = wishListId;
	this.productId = productId;
}


public String getMapId() {
	return mapId;
}
public void setMapId(String mapId) {
	this.mapId = mapId;
}
public String getWishListId() {
	return wishListId;
}
public void setWishListId(String wishListId) {
	this.wishListId = wishListId;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}




}

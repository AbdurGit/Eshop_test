package com.shopping.repository;

import com.shopping.model.User;

public interface IUserRepository {

	public String createUser( String firstNmae,String phone, String lastName, String address,String email,String password);
	
	public String addProductToWishlist(String wishlistId, String productId);
	public User getUserById(String userId);
	public int getUserByEmailOrPhone(String email, String phone);
}

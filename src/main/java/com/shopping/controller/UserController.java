package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.business.UserBusiness;
import com.shopping.model.User;
import com.shopping.repository.UserRepositoryImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepositoryImpl userRepo;
	@Autowired
	private UserBusiness userbusiness;
	
	@RequestMapping(value="/createUser",method=RequestMethod.POST)
	public String createUser(@RequestParam("fname" )String firstName,
			@RequestParam("lname" )String lastName,@RequestParam("phone" )String phone,@RequestParam("address" )String address,@RequestParam("email" )String email,
			@RequestParam("password" )String password) {
		String returnUserId=userbusiness.createUser(firstName,phone,lastName,address,email,password);
		
		
		return returnUserId;
		
	}
	@RequestMapping(value="/getUser", method=RequestMethod.GET)
	public User getUser(@RequestParam("userId")String userId) {
		User user=null;
		try {
			user=userRepo.getUserById(userId);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return user;
	}
	
	@RequestMapping(value="/getUserByUserName", method=RequestMethod.GET)
	public User getUserByUserName(@RequestParam("userId")String userName) {
		User user=null;
		try {
			user=userRepo.getUserByName(userName);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return user;
	}
	
	
	
/*	@RequestMapping(value="/getUserWishlist")
	public String getUserWishlist(@RequestParam("userId")String userId) {
		
		
		
	}
	
	@RequestMapping(value="/getUserCart")
	public String getUserCart(@RequestParam("userId")String userId) {
		
		
		
	}
	*/
	@RequestMapping(value="/addPdtToWishlist")
	public String addProductToWishlist(@RequestParam("wishlistId")String wishlistId,@RequestParam("productId")String productId) {
		
		String mapId=userRepo.addProductToWishlist(wishlistId,productId);
		
		return mapId;
		
	}
	/*@RequestMapping(value="/deletePdtFromWishlist")
	public String deletePdtFromWishlist(@RequestParam("wishlistId")String wishlistId,@RequestParam("productId")String productId) {
		
		
		
	}
	
	
	@RequestMapping(value="/addPdtToCart")
	public String addPdtToCart(@RequestParam("cartId")String cartId,@RequestParam("productId")String productId) {
		
		
		
	}
	@RequestMapping(value="/deletePdtFromCart")
	public String deletePdtFromCart(@RequestParam("cartId")String cartId,@RequestParam("productId")String productId) {
		
		
		
	}*/
	
	
	
	

}

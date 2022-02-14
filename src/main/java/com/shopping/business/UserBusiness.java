package com.shopping.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.repository.UserRepositoryImpl;

@Component
public class UserBusiness {
	@Autowired
	private UserRepositoryImpl userRepoImpl;
	
	public String createUser( String firstNmae, String phone,String lastName, String address,String email,String password) {
		String returnUserId=null;
		int userCount=userRepoImpl.getUserByEmailOrPhone( email, phone);
		if (userCount==0) {
			returnUserId=userRepoImpl.createUser(  firstNmae,  phone, lastName,  address, email, password);
			
			
		}
			
		
		
		return returnUserId;
		
	}

}

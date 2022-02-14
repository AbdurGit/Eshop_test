package com.shopping.repository;

import java.util.ArrayList;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.shopping.model.Cart;
import com.shopping.model.ProductWishListMap;
import com.shopping.model.User;
import com.shopping.model.Wishlist;

@Component
public class UserRepositoryImpl implements IUserRepository {
	private static SessionFactory factory;

	public String createUser( String firstNmae, String phone,String lastName, String address,String email,String password) {

	
		String userIdreturn=null;
		Session session = null;
		Transaction tx = null;

		try {
			factory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Cart.class)
					.addAnnotatedClass(Wishlist.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			
				String userId=UUID.randomUUID().toString();
			
			Cart cart = new Cart();
			cart.setCartId(UUID.randomUUID().toString());
			cart.setCartName(firstNmae + "'s cart");
			

			Wishlist wishlist = new Wishlist();
			wishlist.setWishlistId(UUID.randomUUID().toString());
			wishlist.setWishlistName(firstNmae + "'s wishlist");

			user.setId(userId);
			user.setFirstName(firstNmae);
			user.setLastName(lastName);
			user.setAddress(address);
			user.setPhone(phone);
			user.setPassword(password);
			user.setCart(cart);
			user.setWishlist(wishlist);
			user.setEmail(email);
			cart.setUser(user);
			wishlist.setUser(user);
			 session.save(cart);
			session.save(wishlist);
	 userIdreturn= (String) session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return userIdreturn;
	}

	public User getUserById(String userId) {
		User returnUser = null;
		
		Session session = null;
		Transaction tx = null;
		try {
			factory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Cart.class)
					.addAnnotatedClass(Wishlist.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			
			returnUser= (User) session.get(User.class, userId);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnUser;
	}
	
	public User getUserByName(String userName) {
		User returnUser = null;
		
		Session session = null;
		Transaction tx = null;
		try {
			factory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Cart.class)
					.addAnnotatedClass(Wishlist.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			
			SQLQuery query= session.createSQLQuery("select * from User u where u.firstName =:userName");
			query.setParameter("userName", userName);
			ArrayList userList= new ArrayList<User>();
			userList= (ArrayList) query.list();
			
			if(userList.size()>0) {
				//System.out.println("---------------:"+userList.size());
				//System.out.println("---------------:"+((User) userList.get(0)).getEmail());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return returnUser;
	}




	public String addProductToWishlist(String wishlistId, String productId) {

		
		String mapId=null;
		Session session = null;
		Transaction tx = null;

		try {
			factory = new Configuration().configure().addAnnotatedClass(ProductWishListMap.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			ProductWishListMap pdtwishMap=new ProductWishListMap();
			pdtwishMap.setMapId(UUID.randomUUID().toString());
			pdtwishMap.setProductId(productId);
			pdtwishMap.setWishListId(wishlistId);
			
			
			
		
	         mapId= (String) session.save(pdtwishMap);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return mapId;
	}
	
	public int getUserByEmailOrPhone(String email, String phone) {
		// TODO Auto-generated method stub

		int userCount=0;
		
		Session session = null;
		Transaction tx = null;
		try {
			factory = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Cart.class)
					.addAnnotatedClass(Wishlist.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();

			User user = new User();
			
			SQLQuery query= session.createSQLQuery("select * from User u where u.email =:email or u.phone=:phone");
			query.setParameter("email", email);
			query.setParameter("phone", phone);
			ArrayList userList= new ArrayList<User>();
			userList= (ArrayList) query.list();
			
			if(userList.size()>0) {
				userCount=userList.size();
				//System.out.println("---------------:"+userList.size());
				//System.out.println("---------------:"+((User) userList.get(0)).getEmail());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return userCount;
	
	}
			

			
			
			
			
		
	        
		
	
	public static void main(String[] args) {
		UserRepositoryImpl uri=new UserRepositoryImpl();
		//String id=uri.createUser("34", "abdur", "razzak", "itahar","","");
		//User user=uri.getUserById("34");
		//User user=uri.getUserByName("abdur");
		
		
		//System.out.println(user.getId());
		
	}

	

	








	
}

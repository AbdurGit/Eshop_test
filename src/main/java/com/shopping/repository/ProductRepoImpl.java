package com.shopping.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.shopping.model.Price;
import com.shopping.model.Product;

@Component
public class ProductRepoImpl implements ProductsRepo {
	private static SessionFactory factory;
	
	

	public List<Product> getProducts() {
		System.out.println("inside get pdts repo");
		Session session = null;
		Transaction tx = null;
		List<Product> pdtList=null;
		try {
			factory = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Price.class).buildSessionFactory();
			session = factory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("From Product");
			pdtList = query.list();
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return pdtList;
	}
public Product getProduct(int productId) {
	
	Session session = null;
	Transaction tx = null;
	Product pdt=null;
	try {
		factory = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Price.class).buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		pdt=(Product) session.get(Product.class, productId);
	
		tx.commit();

	} catch (HibernateException e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}

	return pdt;

		
	}
	public static void createProduct() {
		Session session = null;
		Transaction tx = null;

		Product pdt = new Product();
		pdt.setProductId(1);
		pdt.setBrand("Mi");
		factory = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(Price.class)
				.buildSessionFactory();
		session = factory.openSession();
		tx = session.beginTransaction();
		session.save(pdt);

		tx.commit();
		session.close();
	}

	
	
	public static void main(String[] args) {
		//createProduct();
		ProductRepoImpl impl=new ProductRepoImpl();
		Product pdt=impl.getProduct(1);
		System.out.println(pdt.getSpecification());
		
		/*ProductRepoImpl impl=new ProductRepoImpl();
		List<Product> pdtList=impl.getProducts();
		System.out.println(pdtList);*/
	}
public void init() {
	System.out.println("impl init method");
	
}

}

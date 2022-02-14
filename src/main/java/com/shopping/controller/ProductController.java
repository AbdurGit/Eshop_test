package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Product;
import com.shopping.repository.ProductsRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductsRepo productsRepo;

	@RequestMapping(value = "/getProducts", method = RequestMethod.GET, produces = "application/json")
	public List<Product> getProducts() {
		System.out.println("inside get pdts controller");
		List<Product> pdtList = productsRepo.getProducts();
		
		
		return pdtList;
	}

	/*@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, produces = "application/json")
	public Product getProduct(@PathVariable("id") int id) {
		Product pdt=productsRepo.getProduct(id);
		return pdt;
	}*/
	@RequestMapping(value = "/getProduct", method = RequestMethod.GET, produces = "application/json")
	public Product getProduct(@RequestParam("id") int id) {
		Product pdt=productsRepo.getProduct(id);
		return pdt;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		ProductController ct = (ProductController) context.getBean("productController");

		List<Product> pdtList = ct.getProducts();
		System.out.println(pdtList);

	}

	public void init() {
		System.out.println("controller init");
	}

}

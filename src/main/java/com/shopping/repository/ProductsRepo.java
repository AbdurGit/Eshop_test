package com.shopping.repository;

import java.util.List;

import com.shopping.model.Product;





public interface ProductsRepo {
public List<Product> getProducts();
public Product getProduct(int productId);



}

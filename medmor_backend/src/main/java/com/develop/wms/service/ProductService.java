package com.develop.wms.service;

import java.util.List;

import com.develop.wms.entity.Product;


public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product product);
	
	public Product getProductById(int id);
	
	public Product updateProduct (Product product);
	
	public void deleteProductById(int id);
}

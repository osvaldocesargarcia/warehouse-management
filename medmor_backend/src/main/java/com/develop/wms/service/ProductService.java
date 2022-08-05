package com.develop.wms.service;

import java.util.List;

import com.develop.wms.entity.Product;


public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product saveProduct(Product product, int section_id);
	
	public Product getProductById(int id);
	
	public Product updateProduct (Product product);
	
	public void deleteProductById(int id);

	public List<Product> getAllProductsByColor(String color);
	
	public List<Product> getAllProductsBySection(int section_id);

	public List<Product> getAllProductsByLot(int lot);

	public List<Product> getAllProductsByFragility(int is_fragile);

	public List<Product> getAllProductsByContainer(String container_type);

	public List<Product> getAllProductsByPriceInterval(double min, double max);
	
	
	
	
}

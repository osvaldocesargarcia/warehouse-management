package com.develop.wms.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.develop.wms.entity.Product;
import com.develop.wms.repository.ProductRepository;
import com.develop.wms.service.ProductService;
import com.develop.wms.specification.ProductSpecification;
import com.develop.wms.specification.SearchCriteria;


@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl (ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}
	
	
	
	@Override
	public List<Product> getAllProducts(){
		
		return productRepository.findAll();
		
	}
	
	@Override
	public List<Product> getAllProductsByColor(){
		
		ProductSpecification spec = new ProductSpecification(new SearchCriteria("color", ":", "red"));
			    
			    List<Product> results = productRepository.findAll(spec);
			    
			    return results;
		
	}
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
		
	}
	
	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id).get();
		
	}
	
	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}
	

}

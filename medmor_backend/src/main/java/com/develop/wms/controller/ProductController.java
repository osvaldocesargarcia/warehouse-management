package com.develop.wms.controller;

import java.util.List;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.develop.wms.entity.Product;

import com.develop.wms.service.ProductService;

@RestController
@RequestMapping("/api/medmor")

public class ProductController  {
	
	
private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/product")
	public List<Product> listProducts() {
		
		return productService.getAllProducts();
		
	}
	
	

	@CrossOrigin
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		return	productService.saveProduct(product);
	
	}
	
	
}

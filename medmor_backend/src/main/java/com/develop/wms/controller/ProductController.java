package com.develop.wms.controller;

import java.util.List;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.develop.wms.entity.Product;
import com.develop.wms.entity.Section;
import com.develop.wms.service.ProductService;
import com.develop.wms.specification.SectionSpecification;

@RestController
@RequestMapping("/api/medmor")

public class ProductController  {
	
	
private ProductService productService;



	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	

	
	@GetMapping("/product_color")
	public List<Product> listProductsByColor(@RequestParam String color) {
		
		
		return productService.getAllProductsByColor(color);
		
	}
	
	@GetMapping("/product_lot")
	public List<Product> listProductsByLot(@RequestParam int lot) {
		
		
		return productService.getAllProductsByLot(lot);
		
	}
	
	@GetMapping("/product_fragile")
	public List<Product> listProductsByFragility(@RequestParam int is_fragile) {
		
		
		return productService.getAllProductsByFragility(is_fragile);
		
	}
	
	
	@GetMapping("/product_container")
	public List<Product> listProductsByContainer(@RequestParam String container_type) {
		
		
		return productService.getAllProductsByContainer(container_type);
		
	}
	
	
	@GetMapping("/product_price_interval")
	public List<Product> listProductsByPriceInterval(@RequestParam double min, double max ) {
		
		
		return productService.getAllProductsByPriceInterval(min,max);
		
	}
	
	@GetMapping("/product")
	public List<Product> listProducts() {
		
		return productService.getAllProducts();
		
	}
	
	

	@CrossOrigin
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product, @RequestParam int section_id) {
		return	productService.saveProduct(product,section_id);
	
	}
	
	@CrossOrigin
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable int id,@RequestBody Product product_data, @RequestParam int section_id){
		
		Product temp_product = productService.getProductById(id);
		temp_product.setLength(product_data.getLength());
		temp_product.setProduct_type(product_data.getProduct_type());
		temp_product.setWidth(product_data.getWidth());
		temp_product.setColor(product_data.getColor());
		temp_product.setIs_fragile(product_data.isIs_fragile());
		temp_product.setLot(product_data.getLot());
		temp_product.setPrice(product_data.getPrice());
		temp_product.setContainer_type(product_data.getContainer_type());
	
		return productService.saveProduct(temp_product,section_id);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable int id){
		
		productService.deleteProductById(id);
		
	}
	
	@GetMapping("/products_by_section")
	public List<Product> listProductsBySection(@RequestParam int section_id) {
		
		
		return productService.getAllProductsBySection(section_id);
		
	}
	
	
}

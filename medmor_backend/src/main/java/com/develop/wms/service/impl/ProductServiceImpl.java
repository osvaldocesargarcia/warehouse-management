package com.develop.wms.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.develop.wms.entity.Product;
import com.develop.wms.entity.Section;
import com.develop.wms.enums.Container_Type;
import com.develop.wms.repository.ProductRepository;
import com.develop.wms.repository.SectionRepository;
import com.develop.wms.service.ProductService;
import com.develop.wms.service.SectionService;
import com.develop.wms.specification.ProductSpecification;
import com.develop.wms.specification.SearchCriteria;
import com.develop.wms.specification.SectionSpecification;



@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	private SectionRepository sectionRepository;
	
	
	public ProductServiceImpl (ProductRepository productRepository, SectionRepository sectionRepository ) {
		
		this.productRepository = productRepository;
		this.sectionRepository = sectionRepository;
	}
	
	
	
	@Override
	public List<Product> getAllProducts(){
		
		return productRepository.findAll();
		
	}
	

	
	
	@Override
	public List<Product> getAllProductsByColor(String color){
		
		
		ProductSpecification spec = new ProductSpecification(new SearchCriteria("color", ":", color));
			    
			    List<Product> results = productRepository.findAll(spec);
			    
			    return results;
		
	}
	
	
	
	@Override
	public List<Product> getAllProductsByLot(int lot) {
		
		ProductSpecification spec = new ProductSpecification(new SearchCriteria("lot", ":", lot));
	    
	    List<Product> results = productRepository.findAll(spec);
		
		return results;
	}
	
	@Override
	public List<Product> getAllProductsByFragility(int is_fragile) {
		
		boolean value = false;
		if(is_fragile == 1) {
			value=true;
		}
		
		ProductSpecification spec = new ProductSpecification(new SearchCriteria("is_fragile", ":", value));
	    
	    List<Product> results = productRepository.findAll(spec);
		
		return results;
	}
	
	
	@Override
	public List<Product> getAllProductsByPriceInterval(double min, double max) {
		
			
		
		ProductSpecification spec1 = new ProductSpecification(new SearchCriteria("price", ">", min));
		ProductSpecification spec2 = new ProductSpecification(new SearchCriteria("price", "<", max));
	    
	    List<Product> results = productRepository.findAll(Specification.where(spec1).and(spec2));
		
		return results;
		
	}
	
	public List<Product> getAllProductsByContainer(String container_type) {
		
		Container_Type container_value = null;
		
		System.out.println("a"+container_type);
		
		switch(container_type) {
		case "PLASTIC": container_value = Container_Type.PLASTIC;
		break;
		
		case "CARTON": 	container_value = Container_Type.CARTON;
		break;
		
		case "GLASS": 	container_value = Container_Type.GLASS;
		break;
		
		case "NYLON": 	container_value = Container_Type.NYLON;
		break;
		
		
		
		}
		
		ProductSpecification spec = new ProductSpecification(new SearchCriteria("container_type", ":", container_value));
	    
	    List<Product> results = productRepository.findAll(spec);
		
		return results;
	}
	
	
	
	@Override
	public Product saveProduct(Product product, int section_id) {
		
		SectionSpecification spec = new SectionSpecification(new SearchCriteria("section_id", ":", section_id));
	    List<Section> results = sectionRepository.findAll(spec);
		
	    product.setSection_assigned(results.get(0));
	    
		boolean no_availableCapacity = no_availableCapacity(product);
		
		if(no_availableCapacity) {
			/*TODO Feedback message for capacity of products*/
			System.out.println("No capacity left for any other product");
			return new Product();
		}
		else {
			return productRepository.save(product);
		}
	
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


	@Override
	public  List<Product> getAllProductsBySection(int section_id){
		
		List<Product> products_results = new ArrayList<>();
		SectionSpecification spec = new SectionSpecification(new SearchCriteria("section_id", ":", section_id));
	    List<Section> results = sectionRepository.findAll(spec);
	    
	    if(results.isEmpty()) {
	    	
	    	/*TODO Create feedback message  */
			System.out.println("Section not found");
			 
		}else {
			 
			
	     products_results.addAll(results.get(0).getProducts_list()) ;
	     
	   
	    }

	    return  products_results; 
	    
	}
	
	
	public boolean no_availableCapacity(Product product) {
		
		boolean no_available = false;
		int section_id = product.getSection_assigned().getSection_id();
		
		ArrayList<Product> product_list = (ArrayList<Product>) getAllProductsBySection(section_id);
	
		double  max_capacity = product.getSection_assigned().getLength()*product.getSection_assigned().getWidth();
		double  occupied_capacity = product.getLength()*product.getWidth();
		
		for(int i = 0; i < product_list.size() && !no_available;i++) {
			occupied_capacity += product_list.get(i).getLength()*product_list.get(i).getWidth();
			
			if(occupied_capacity > max_capacity) {
				
				no_available = true;
			}
		}
	
		return no_available;
			
	}





	

	

	
}

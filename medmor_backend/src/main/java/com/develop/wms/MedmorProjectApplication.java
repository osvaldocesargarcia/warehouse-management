package com.develop.wms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.develop.wms.entity.Product;
import com.develop.wms.entity.Product_Type;
import com.develop.wms.entity.Section;
import com.develop.wms.repository.ProductRepository;
import com.develop.wms.repository.SectionRepository;
import com.develop.wms.service.ProductService;
import com.develop.wms.service.SectionService;
import com.develop.wms.service.impl.ProductServiceImpl;


@SpringBootApplication
public class MedmorProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MedmorProjectApplication.class, args);
	}
	
	// TODO Delete elements from run function and repositories and IMPORTS
	/*
@Autowired
private SectionRepository sectionRepository;
@Autowired
private ProductService productService;

@Autowired
private SectionService sectionService;
	*/
	
	@Override
	public void run (String... args) throws Exception{
		
		/*
		Section section = this.sectionService.getSectionById(8);
		
		sectionRepository.save(section);
		
		Product product = new Product(1.5, 2.5, "red", 10.8, true, 1,
				Product_Type.ELECTRICAL_MATERIALS, section);
		System.out.println("a");
		productService.saveProduct(product);
		
	*/
	}
	
}

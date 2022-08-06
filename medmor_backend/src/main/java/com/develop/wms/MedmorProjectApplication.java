package com.develop.wms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import com.develop.wms.entity.Product;
import com.develop.wms.entity.Section;
import com.develop.wms.enums.Product_Type;
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
	

	
	@Override
	public void run (String... args) throws Exception{
		

	}
	
}

package com.develop.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.develop.wms.entity.Product;




public interface ProductRepository extends JpaRepository<Product, Integer> , JpaSpecificationExecutor<Product>{

	
	
}

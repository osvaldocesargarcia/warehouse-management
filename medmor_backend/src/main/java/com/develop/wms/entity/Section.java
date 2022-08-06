package com.develop.wms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.develop.wms.enums.Product_Type;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="section")
public class Section {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="section_id")
	private int section_id;
	
	@Column(name="length")
	private double length;
	
	@Column(name="width")
	private double width;
	
	@JsonIgnore  
	@OneToMany(mappedBy="section_assigned") 
	private Set<Product> products_list;
	
	@Column(name = "product_type")
	@Enumerated(EnumType.STRING)
	private Product_Type product_type;
	

	public Section(double length, double width,   Product_Type product_type) {
		super();
		this.length = length;
		this.width = width;
		this.products_list = new HashSet<Product>();
		this.product_type = product_type;
	}


	
	public int getSection_id() {
		return section_id;
	}


	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public Set<Product> getProducts_list() {
		return products_list;
	}


	public void setProducts_list(Set<Product> products_list) {
		this.products_list = products_list;
	}


	public Product_Type getProduct_type() {
		return product_type;
	}


	public void setProduct_type(Product_Type product_type) {
		this.product_type = product_type;
	}



	public Section() {
		
	}
	

	

}

package com.develop.wms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int product_id;

	
	@Column(name="length")
	private double length;
	
	@Column(name="width")
	private double width;
	
	@Column(name="color")
	private String color;
	
	@Column(name="price")
	private double price;
	
	
	@Column(name="is_fragile")
	private boolean is_fragile;
	
	@Column(name="lot")
	private int lot;
	
	@Column(name = "product_type")
	@Enumerated(EnumType.STRING)
	private Product_Type product_type;
	
	
	@ManyToOne
    @JoinColumn(name="section_id", nullable=false)
	private Section section_assigned;
	
	
	
	
	public Product () {
		
		
	}
	
	

	



}

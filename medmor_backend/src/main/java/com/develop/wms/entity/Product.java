package com.develop.wms.entity;



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

import com.develop.wms.enums.Container_Type;
import com.develop.wms.enums.Product_Type;

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
	
	@Column(name = "container_type")
	@Enumerated(EnumType.STRING)
	private Container_Type container_type;
	
	@ManyToOne
    @JoinColumn(name="section_id", nullable=false)
	private Section section_assigned;
	
	

	public Product () {
		
		
	}
	
	public Product(double length, double width, String color, double price, boolean is_fragile, int lot,
			Product_Type product_type, Container_Type container_type, Section section_assigned) {
		super();
		this.length = length;
		this.width = width;
		this.color = color;
		this.price = price;
		this.is_fragile = is_fragile;
		this.lot = lot;
		this.product_type = product_type;
		this.section_assigned = section_assigned;
		this.container_type = container_type;
	}

	
	
	public int getProduct_id() {
		return product_id;
	}




	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public boolean isIs_fragile() {
		return is_fragile;
	}




	public void setIs_fragile(boolean is_fragile) {
		this.is_fragile = is_fragile;
	}




	public int getLot() {
		return lot;
	}




	public void setLot(int lot) {
		this.lot = lot;
	}




	public Product_Type getProduct_type() {
		return product_type;
	}




	public void setProduct_type(Product_Type product_type) {
		this.product_type = product_type;
	}




	public Section getSection_assigned() {
		
		//section_assigned.setProducts_list(null);
        
		return section_assigned;
	}




	public void setSection_assigned(Section section_assigned) {
		this.section_assigned = section_assigned;
	}

	public Container_Type getContainer_type() {
		return container_type;
	}

	public void setContainer_type(Container_Type container_type) {
		this.container_type = container_type;
	}


	
	
	
	
	

	



}

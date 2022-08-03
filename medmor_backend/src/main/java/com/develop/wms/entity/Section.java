package com.develop.wms.entity;

import java.util.List;
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
	
	@OneToMany(mappedBy="section_assigned") 
	private Set<Product> products_list;
	
	@Column(name = "product_type")
	@Enumerated(EnumType.STRING)
	private Product_Type product_type;
	

	public Section() {
		
	}
	

	

}

package com.develop.wms.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.develop.wms.entity.Product;
import com.develop.wms.entity.Section;
import com.develop.wms.repository.SectionRepository;
import com.develop.wms.service.SectionService;

@RestController
@RequestMapping("/api/medmor")
public class SectionController {
	
	private SectionService sectionService;

	public SectionController(SectionService sectionService) {
		super();
		this.sectionService = sectionService;
	}
	@CrossOrigin
	@GetMapping("/section")
	public List<Section> listSections() {
		
		return sectionService.getAllSections();
		
	}
	

	@CrossOrigin
	@PostMapping("/section")
	public Section saveSection(@RequestBody Section section) {
		return	sectionService.saveSection(section);
	
	}
	
	
	@PutMapping("/section/{id}")
	public Section updateSection(@PathVariable int id,@RequestBody Section section_data){
		
		Section temp_section = sectionService.getSectionById(id);
		temp_section.setLength(section_data.getLength());
		temp_section.setProduct_type(section_data.getProduct_type());
		temp_section.setProducts_list(section_data.getProducts_list());
		temp_section.setWidth(section_data.getWidth());
	
		return sectionService.saveSection(temp_section);
		
	}
	
	
	@DeleteMapping("/section/{id}")
	public void deleteSection(@PathVariable int id){

		sectionService.deleteSectionById(id);
		
	}


}

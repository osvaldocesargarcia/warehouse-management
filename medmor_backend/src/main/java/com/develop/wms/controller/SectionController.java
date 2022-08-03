package com.develop.wms.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.develop.wms.entity.Section;

import com.develop.wms.service.SectionService;

@RestController
@RequestMapping("/api/medmor")
public class SectionController {
	
	private SectionService sectionService;

	public SectionController(SectionService sectionService) {
		super();
		this.sectionService = sectionService;
	}
	
	@GetMapping("/section")
	public List<Section> listSections() {
		
		return sectionService.getAllSections();
		
	}
	
	

	@CrossOrigin
	@PostMapping("/section")
	public Section saveSection(@RequestBody Section section) {
		return	sectionService.saveSection(section);
	
	}

}

package com.develop.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.develop.wms.entity.Product;
import com.develop.wms.entity.Section;
import com.develop.wms.repository.SectionRepository;
import com.develop.wms.service.SectionService;


@Service
public class SectionServiceImpl implements SectionService {
	
	
	private SectionRepository sectionRepository;
	
	public SectionServiceImpl (SectionRepository sectionRepository) {
		
		this.sectionRepository = sectionRepository;
	}
	
	
	@Override
	public List<Section> getAllSections(){
		
		return sectionRepository.findAll();
		
	}
	

	
	@Override
	public Section saveSection(Section section) {
		return sectionRepository.save(section);
		
	}
	
	@Override
	public Section getSectionById(int id) {
		System.out.println("id = "+id);
		
		
		return sectionRepository.findById(id).get();
		
	}
	
	@Override
	public Section updateSection(Section section) {
		return sectionRepository.save(section);
	}
	
	@Override
	public void deleteSectionById(int id) {
		sectionRepository.deleteById(id);
	}

}

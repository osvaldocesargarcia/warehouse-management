package com.develop.wms.service;

import java.util.List;


import com.develop.wms.entity.Section;

public interface SectionService {
	
	
	public List<Section> getAllSections();
	
	public Section saveSection(Section section);
	
	public Section getSectionById(int id);
	
	public Section updateSection (Section section);
	
	public void deleteSectionById(int id);

}

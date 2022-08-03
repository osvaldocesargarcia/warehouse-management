package com.develop.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import com.develop.wms.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Integer>, JpaSpecificationExecutor<Section> {

}

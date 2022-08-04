package com.develop.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.develop.wms.entity.Section;

@CrossOrigin
@Repository
public interface SectionRepository extends JpaRepository<Section, Integer>, JpaSpecificationExecutor<Section> {

}

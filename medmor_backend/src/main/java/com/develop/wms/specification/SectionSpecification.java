package com.develop.wms.specification;


import org.springframework.data.jpa.domain.Specification;



import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;



import com.develop.wms.entity.Section;

public class SectionSpecification implements Specification<Section> {

    private SearchCriteria criteria;

 
	public SectionSpecification(final SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}
	

	public SearchCriteria getCriteria() {
		return criteria;
	}
    
    
    @Override
    public javax.persistence.criteria.Predicate toPredicate
      (Root<Section> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
 
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
              root.<String> get(criteria.getKey()), criteria.getValue().toString());
        } 
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                  root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
    
    
    
    
    

}
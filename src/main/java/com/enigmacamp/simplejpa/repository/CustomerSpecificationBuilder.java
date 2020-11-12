package com.enigmacamp.simplejpa.repository;

import com.enigmacamp.simplejpa.model.Customer;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerSpecificationBuilder implements Specification<Customer> {
    private final SearchCriteria criteria;

    public CustomerSpecificationBuilder(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Specification<Customer> and(Specification<Customer> other) {
        return null;
    }

    @Override
    public Specification<Customer> or(Specification<Customer> other) {
        return null;
    }


    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        switch (criteria.getOperation()) {
            case CONTAINS:
                return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
            case START_WITH:
                return criteriaBuilder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            case END_WITH:
                return criteriaBuilder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
            case EQUALS:
                return criteriaBuilder.equal(root.get(criteria.getKey()),  criteria.getValue());
            default:
                return null;
        }
    }

}

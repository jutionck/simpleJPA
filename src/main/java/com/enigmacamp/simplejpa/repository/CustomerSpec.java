package com.enigmacamp.simplejpa.repository;

import com.enigmacamp.simplejpa.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.List;

public class CustomerSpec {
    public static Specification<Customer> multi(List<SearchCriteria> criterias) {
        //Lambda Expression
        return (customer, cq, cb) -> {
            Predicate[] predicates = new Predicate[criterias.size()];
            for (int i = 0; i < criterias.size(); i++) {
                predicates[i] = new CustomerSpecificationBuilder(criterias.get(i)).toPredicate(customer, cq, cb);
            }
            return cb.and(predicates);
        };
    }

    public static Specification<Customer> single(SearchCriteria criteria) {
        return (customer, cq, cb) -> new CustomerSpecificationBuilder(criteria).toPredicate(customer, cq, cb);
    }
}

package com.enigmacamp.simplejpa.service;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerRegistration;
import com.enigmacamp.simplejpa.model.UserAccount;
import com.enigmacamp.simplejpa.repository.*;
import com.enigmacamp.simplejpa.utils.SortDirection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImplementation.class);

    CustomerRepo customerRepo;
    UserAccountRepo userAccountRepo;

    //Automatically autowired if there is only 1 constructor, @autowired is not needed
    CustomerServiceImplementation(CustomerRepo customerRepo, UserAccountRepo userAccountRepo) {
        Objects.requireNonNull(customerRepo);
        this.customerRepo = customerRepo;
        this.userAccountRepo = userAccountRepo;
    }

    //Insert data to m_customer and m_user_account
    @Transactional
    @Override
    public Customer registration(CustomerRegistration customerRegistration) {
        Customer newCustomer = customerRepo.save(customerRegistration.getCustomer());
        UserAccount userAccount = customerRegistration.getUserAccount();
        userAccount.setCustomerId(newCustomer.getId());
        userAccount.setIsActive(0);
        userAccountRepo.save(userAccount);
        return newCustomer;
    }

    @Override
    public Customer activation(String customerId) {
       return customerRepo.getOne(customerId);
    }

    @Override
    public Customer unregistration(String customerId) {
        return null;
    }

    //Pagination
    @Override
    public Page<Customer> getAllCustomer(int page, int size, String[] sort) {
        List<Sort.Order> orders = new ArrayList<>();
        for(String ord : sort) {
            String[] _order = ord.split(",");
            orders.add(new Sort.Order(new SortDirection().getSortDirection(_order[1]), _order[0]));
        }
        Pageable paging = PageRequest.of(page,size, Sort.by(orders));
        return customerRepo.findAll(paging);
    }

    @Override
    public void printList(List<Customer> customers) {
        customers.forEach(customer -> log.debug(customer.toString()));
    }

    @Override
    public List<Customer> findCustomer(SearchCriteria searchCriteria) {
        return customerRepo.findAll(CustomerSpec.single(searchCriteria));
    }

    @Override
    public List<Customer> findCustomer(List<SearchCriteria> searchCriteria) {
        return customerRepo.findAll(CustomerSpec.multi(searchCriteria));
    }

}

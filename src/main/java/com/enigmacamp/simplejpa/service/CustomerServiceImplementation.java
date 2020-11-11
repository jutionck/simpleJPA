package com.enigmacamp.simplejpa.service;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerName;
import com.enigmacamp.simplejpa.model.CustomerRegistration;
import com.enigmacamp.simplejpa.model.UserAccount;
import com.enigmacamp.simplejpa.repository.CustomerRepo;
import com.enigmacamp.simplejpa.repository.UserAccountRepo;
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

    //Insert Data
//    @Override
//    public Customer registration(Customer customer) {
//        return customerRepo.save(customer);
//    }

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
        Page<Customer> customerPaging = customerRepo.findAll(paging);
        return customerPaging;
    }

//    @Override
//    public List<Customer> getAllCustomer(int page, int size) {
//        Pageable paging = PageRequest.of(page,size);
//        Page<Customer> customerPaging = customerRepo.findAll(paging);
//
//        return customerPaging.getContent();
//
//        //atau
//        //List<Customer> customers = customerPaging.getContent();
//        //        return customers;
//    }

//    @Override
//    public List<Customer> getAllCustomer() {
//        return customerRepo.findAll();
//    }

    @Override
    public void printList(List<Customer> customers) {
        customers.forEach(customer -> log.debug(customer.toString()));
    }

    @Override
    public List<Customer> getCustomerByName(CustomerName containingBy, String name) {
        List<Customer> customers = new ArrayList<>();
        switch (containingBy) {
            case FIRSTNAME_CONTAINING:
                customers = customerRepo.findByFirstNameContaining(name);
                break;
            case LASTNAME_CONTAINING:
                customers = customerRepo.findByLastNameContaining(name);
                break;
            case FIRSTNAME_STARTING:
                customers = customerRepo.findCustomerFirstNameStartWith(name);
                break;
        }
        return customers;
    }


}

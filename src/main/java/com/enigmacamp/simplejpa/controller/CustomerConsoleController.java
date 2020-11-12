package com.enigmacamp.simplejpa.controller;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerRegistration;
import com.enigmacamp.simplejpa.model.UserAccount;
import com.enigmacamp.simplejpa.repository.CriteriaOperation;
import com.enigmacamp.simplejpa.repository.SearchCriteria;
import com.enigmacamp.simplejpa.service.CustomerService;
import com.enigmacamp.simplejpa.utils.ErrorMessage;
import com.enigmacamp.simplejpa.utils.JsonUtils;
import com.enigmacamp.simplejpa.utils.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
//CommandLineRunner akan menampilkan informasi hanya di terminal di IDE
public class CustomerConsoleController implements CommandLineRunner {

    //Inject customer Service
    @Autowired
    JsonUtils jsonUtils;
    CustomerService customerService;

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    CustomerConsoleController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private void customerRegistrationForm(String firstName, String lastName, String userName, String password) {
        try {
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(firstName);
            newCustomer.setLastName(lastName);
            //Customer Registration input
            UserAccount newUserAccount = new UserAccount();
            newUserAccount.setUserName(userName);
            newUserAccount.setUserPassword(password);
            CustomerRegistration customerRegistration = new CustomerRegistration(newCustomer, newUserAccount);
            Customer customer =  customerService.registration(customerRegistration);

            SimpleResponse<Customer> response = new SimpleResponse<>();
            response.setMessage("SUCCESS");
            response.setData(customer);
            log.debug(jsonUtils.create(response));
        } catch (Exception e) {
            log.error(jsonUtils.create(new ErrorMessage("X06", new Date(), e.getMessage())));
        }
    }

    private void searchCustomer(String value) {
        List<Customer> customers = customerService.findCustomer(new SearchCriteria("firstName", CriteriaOperation.START_WITH, value));
        SimpleResponse<List<Customer>> response = new SimpleResponse<>();
        response.setMessage("SUCCESS");
        response.setData(customers);
        log.debug(jsonUtils.create(response));
    }

    private void advancedSearchCustomer() {
        List<SearchCriteria> criteriaList = new ArrayList<>();
        criteriaList.add(new SearchCriteria("firstName", CriteriaOperation.START_WITH, "E"));
        criteriaList.add(new SearchCriteria("address", CriteriaOperation.START_WITH, "J"));
        List<Customer> customers = customerService.findCustomer(criteriaList);
        SimpleResponse<List<Customer>> response = new SimpleResponse<>();
        response.setMessage("SUCCESS");
        response.setData(customers);
        log.debug(jsonUtils.create(response));
    }

    @Override
    //Running aplikasi
    public void run(String... args) throws Exception {
        //Insert Data
       //customerRegistrationForm("Edo", "Hokage", "edo.hokage", "1234");

        //searchCustomer("D");
        advancedSearchCustomer();

    }
}

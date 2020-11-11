package com.enigmacamp.simplejpa.controller;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.model.CustomerRegistration;
import com.enigmacamp.simplejpa.model.UserAccount;
import com.enigmacamp.simplejpa.service.CustomerService;
import com.enigmacamp.simplejpa.utils.ErrorMessage;
import com.enigmacamp.simplejpa.utils.JsonUtils;
import com.enigmacamp.simplejpa.utils.SimpleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

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

    @Override
    //Running aplikasi
    public void run(String... args) throws Exception {
        //Insert Data to table m_customer
//        Customer newCustomer = new Customer();
//        newCustomer.setFirstName("Destry");
//        newCustomer.setLastName("Faradila");
//        customerService.registration(newCustomer);

        //Get All Data
        //List<Customer> customers = customerService.getAllCustomer();
        //customerService.printList(customers);

        //Get by LIKE
        //List<Customer> customers = customerService.getCustomerByName(CustomerName.FIRSTNAME_CONTAINING, "J");
        //customerService.printList(customers);

        //List<Customer> customers1 = customerService.getCustomerByName(CustomerName.FIRSTNAME_CONTAINING, "A");
        //customerService.printList(customers1);

        //View with pagination
//        List<Customer> customers = customerService.getAllCustomer(0,2);
//        customerService.printList(customers);
//
//        List<Customer> customers1 = customerService.getAllCustomer(1,2);
//        customerService.printList(customers1);

//        String[] sorting = {"lastName,asc"};
//        Page<Customer> customers = customerService.getAllCustomer(0,2, sorting);
//        ResponsePaging<List<Customer>> responsePaging = new ResponsePaging<>();
//        responsePaging.setMessage("SUCCESS");
//        responsePaging.setData(customers.getContent());
//        responsePaging.setCurrentPage(customers.getNumber());
//        responsePaging.setTotalItems(customers.getTotalElements());
//        responsePaging.setTotalPages(customers.getTotalPages());
//
//        ObjectMapper om = new ObjectMapper();
//        String jsonString = om.writeValueAsString(responsePaging);
        //Print out json result in command liner
//        System.out.println(jsonString);
//        log.debug(jsonString);
       customerRegistrationForm("Edo", "Hokage", "edo.hokage", "1234");


    }
}

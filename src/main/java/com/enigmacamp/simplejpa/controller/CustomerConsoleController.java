package com.enigmacamp.simplejpa.controller;

import com.enigmacamp.simplejpa.model.Customer;
import com.enigmacamp.simplejpa.service.CustomerService;
import com.enigmacamp.simplejpa.utils.ResponsePaging;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//CommandLineRunner akan menampilkan informasi hanya di terminal di IDE
public class CustomerConsoleController implements CommandLineRunner {
    //Inject customer Service
    CustomerService customerService;

    CustomerConsoleController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    //Running aplikasi
    public void run(String... args) throws Exception {

        //Insert Data to table m_customer
        //Customer newCustomer = new Customer();
        //newCustomer.setFirstName("Jution");
        //newCustomer.setLastName("Kirana");
        //customerService.registration(newCustomer);

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

        String[] sorting = {"lastName,asc"};
        Page<Customer> customers = customerService.getAllCustomer(0,2, sorting);
        ResponsePaging<List<Customer>> responsePaging = new ResponsePaging<>();
        responsePaging.setMessage("SUCCESS");
        responsePaging.setData(customers.getContent());
        responsePaging.setCurrentPage(customers.getNumber());
        responsePaging.setTotalItems(customers.getTotalElements());
        responsePaging.setTotalPages(customers.getTotalPages());

        ObjectMapper om = new ObjectMapper();
        String jsonString = om.writeValueAsString(responsePaging);
        log.debug(jsonString);

    }
}

package com.enigmacamp.simplejpa.model;

public class CustomerRegistration {

    Customer customer;
    UserAccount userAccount;

    public CustomerRegistration() {}

    public CustomerRegistration(Customer customer, UserAccount userAccount) {
        this.customer = customer;
        this.userAccount = userAccount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}

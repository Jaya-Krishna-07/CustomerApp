package com.customerapp.service;

import com.customerapp.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(String id);
}

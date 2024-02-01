package com.customerapp.service.impl;

import com.customerapp.Exception.ResourceNotFound;
import com.customerapp.entity.Customer;
import com.customerapp.repository.CustomerRepository;
import com.customerapp.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        String id = UUID.randomUUID().toString();
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Customer not found with id: " + id)
        );
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(String id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
        return "customer with id: " + id + " deleted successfully";
    }
}

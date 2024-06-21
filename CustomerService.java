package com.cabbooking.service;

import com.cabbooking.model.Customer;
import com.cabbooking.repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();
    
    public void registerCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }
    
    public void listCustomers() {
        for (Customer customer : customerRepository.getCustomers()) {
            System.out.println(customer.getName());
        }
    }
}

package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
   private final CustomerRepository customerRepository;

   @Autowired
   public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
   }


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // todo: Check if email valid
        // todo: check if email not taken
        // todo: check if fraudster

        customerRepository.save(customer);
    }
}

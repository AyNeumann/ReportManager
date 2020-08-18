package com.aymeric.medreport.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aymeric.medreport.model.Customer;
import com.aymeric.medreport.repository.CustomerRepository;

/**
 * Customer service class
 * @author Aymeric NEUMANN
 *
 */
@Service
public class CustomerService {
    
    /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    
    /** Number of user return per page. */
    private static final int NUM_OF_USER_PER_PAGE = 50;
    
    /** Reference to the customer repository */
    @Autowired
    private CustomerRepository customerRepository;
    
    public Customer getCustomerById(final Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        
        if(!customer.isPresent()) {
            logger.info("No customer found with the id: {}", id);
            //TODO: throw exception
        }
        
        return customer.get();
    }
    
    public Page<Customer> getCustomersByLastName(final String lastName, final Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, NUM_OF_USER_PER_PAGE, Sort.by("lastName"));
        
        Page<Customer> customers = customerRepository.findByLastNameContaining(pageable, lastName);
        
        if(customers.isEmpty()) {
            logger.info("No customer with the last name {} found with the id: {}", lastName, pageNumber);
        }
        
        return customers;
    }

}

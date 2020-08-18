package com.aymeric.medreport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aymeric.medreport.model.Customer;
import com.aymeric.medreport.service.CustomerService;

/**
 * Customer Controller manage request about customers
 * @author Aymeric NEUMANN
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    
    /** Reference to customer service class */
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getById(@RequestParam(name = "id") final Long id) {
        logger.debug("Getting customer with the id: {}", id);
        return customerService.getCustomerById(id);
    }
    
    @GetMapping("/byLastName")
    public Page<Customer> getByLastName(@RequestParam(name = "lastName") final String lastName, @RequestParam(name = "pageNumber") final Integer pageNumber){
        logger.debug("Getting customer with the last name as: {}", lastName);
        return null;
    }
}

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

import io.swagger.annotations.ApiOperation;

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

    /**
     * Get a customer by Id
     * @param id id of the customer to get
     * @return the found customer or ??
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get customer by Id", notes = "Getting a customer by his id", response = Customer.class)
    public Customer getById(@RequestParam(name = "id") final Long id) {
        logger.debug("Getting customer with the id: {}", id);
        return customerService.getCustomerById(id);
    }
    
    @GetMapping("/byLastName")
    @ApiOperation(value = "Get customer by last name", notes = "Getting a customer by his last name")
    public Page<Customer> getByLastName(@RequestParam(name = "lastName") final String lastName, @RequestParam(name = "pageNumber") final Integer pageNumber){
        logger.debug("Getting customer with the last name as: {}", lastName);
        return null;
    }
}

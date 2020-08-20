package com.aymeric.medreport.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aymeric.medreport.dto.MedReportEntityExceptionDTO;
import com.aymeric.medreport.model.Customer;
import com.aymeric.medreport.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * Customer Controller manage request about customers
 * @author Aymeric NEUMANN
 *
 */
@RestController
@RequestMapping("/customer")
@Api(value = "CustomerController")
public class CustomerController {

    /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    /** Reference to customer service class */
    @Autowired
    private CustomerService customerService;

    /**
     * Create a customer
     * @param customer customer to create
     * @return created customer
     */
    @PostMapping("")
    @ApiOperation(value = "Create a customer", notes = "Save a customer in the database")
    public Customer create(@RequestBody @Valid Customer customer) {
        logger.debug("Saving the customer: {}", customer);
        return customerService.createCustomer(customer);
    }

    /**
     * Get a customer by Id
     * @param id id of the customer to get
     * @return the found customer or MedReportEntityExceptionDTO
     */
    @GetMapping("byId")
    @ApiOperation(value = "Get customer by Id", notes = "Getting a customer by his id")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, response = Customer.class, message = "Success"),
            @ApiResponse(code = 400, response = MedReportEntityExceptionDTO.class, message = "Bad Request")
    }
            )
    public Customer getById(@RequestParam(name = "id") final Long id) {
        logger.debug("Getting customer with the id: {}", id);
        return customerService.getCustomerById(id);
    }

    /**
     * Get one or many customers by last name
     * @param id last name of the customer to get
     * @return a page of customers or an empty page
     */
    @GetMapping("/byLastName")
    @ApiOperation(value = "Get customer by last name", notes = "Getting one or many customers by last name")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, response = Page.class, message = "Success"), 
    }
            )
    public Page<Customer> getByLastName(@RequestParam(name = "lastName") final String lastName, @RequestParam(name = "pageNumber") final Integer pageNumber){
        logger.debug("Getting customer with the last name as: {}", lastName);
        return customerService.getCustomersByLastName(lastName, pageNumber);
    }
    
    /**
     * Delete the customer with the matching id
     * @param id id of the customer to delete
     * @return true if the customer has been deleted false otherwise
     */
    @ApiOperation(value = "Delete customer by id", notes = "Deleting the customer with the matching id")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, response = Boolean.class, message = "Success"),
            @ApiResponse(code = 400, response = MedReportEntityExceptionDTO.class, message = "Bad Request")
    }
            )
    @DeleteMapping("/delete")
    public boolean deleteById(@RequestParam(name = "id") final Long id) {
        logger.debug("Deleting customer with the id: {}", id);
        return customerService.deleteCustomerById(id);
    }
}

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

import com.aymeric.medreport.dto.MedReportEntityExceptionDTO;
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

    /**
     * Get a customer by Id
     * @param id id of the customer to get
     * @return the found customer or MedReportEntityExceptionDTO
     */
    public Customer getCustomerById(final Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(!customer.isPresent()) {
            String errMessage = String.format("No customer found with the id: %s", id);
            logger.info(errMessage);
            throw new MedReportEntityExceptionDTO(errMessage);
        }

        return customer.get();
    }

    /**
     * Get one or many customers by last name
     * @param id last name of the customer to get
     * @return a page of customers or an empty page
     */
    public Page<Customer> getCustomersByLastName(final String lastName, final Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, NUM_OF_USER_PER_PAGE, Sort.by("lastName"));

        Page<Customer> customers = customerRepository.findByLastNameContainingIgnoreCase(pageable, lastName);

        if(customers.isEmpty()) {
            logger.info("No customer with the last name {} found with the id: {}", lastName, pageNumber);
        }

        return customers;
    }

    /**
     * Create a customer
     * @param customer customer to create
     * @return created customer
     */
    public Customer createCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Delete the customer with the matching id
     * @param id id of the customer to delete
     * @return true if the customer has been deleted false otherwise
     */
    public boolean deleteCustomerById(final Long id) {
        boolean isCustomerDeleted = false;
        boolean isCustomerValid = customerRepository.existsById(id);

        if(isCustomerValid) {
            logger.debug("Deleting customer with the id: {}", id);
            customerRepository.deleteById(id);
            isCustomerDeleted = true;
        } else {
            String errMessage = String.format("No customer found with the id: %s", id);
            logger.info(errMessage);
            throw new MedReportEntityExceptionDTO(errMessage);
        }

        return isCustomerDeleted;
    }

}

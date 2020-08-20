package com.aymeric.medreport.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.aymeric.medreport.model.Customer;

/**
 * Customer repository
 * @author Aymeric NEUMANN
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,  PagingAndSortingRepository<Customer, Long>{
    
    /**
     * Find all customer with a similar last name and return it in a paged result
     * @param pageable page parameters
     * @return a page of result
     */
    Page<Customer> findByLastNameContaining(Pageable pageable, String lastName);
}

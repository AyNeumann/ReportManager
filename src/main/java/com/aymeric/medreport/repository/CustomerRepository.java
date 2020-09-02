package com.aymeric.medreport.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aymeric.medreport.model.Customer;

/**
 * Customer repository
 * @author Aymeric NEUMANN
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,  PagingAndSortingRepository<Customer, Long>{
    
    //@Query(value = "SELECT c FROM customer as c LEFT OUTER JOIN customer_address ON customer_address.customer_id = :id LEFT OUTER JOIN customer_reports ON customer_address.customer_id = :id WHERE id = :id", nativeQuery = true)
    Optional<Customer> findById(@Param("id") Long id);
    
    /**
     * Find all customer with a last name that contains the lastName parameter and return it in a paged result
     * @param pageable page parameters
     * @return a page of matching customer
     */
    Page<Customer> findByLastNameContainingIgnoreCase(String lastName, Pageable pageable);
    
    /*Slice is like a page but will not contains the total number of item. Could be useful because
     * getting the total number of item could be an expensive query.
     * Note: if we don't want to get all the attribute from the page (last, totalPages etc...) 
     * a simple List could be use
     */
    /**
     * Find all customer with a first name that contains the lastName parameter and return it in a paged result
     * @param pageable page parameters
     * @return a slice of matching customer
     */
    Slice<Customer> findByFirstNameContainingIgnoreCase(String lastName, Pageable pageable);
    
    /**
     * Find all customer with a similar last name and return it in a paged result
     * @param pageable page parameters
     * @return a page of matching customer
     */
    Page<Customer> findByLastNameLikeIgnoreCase(Pageable pageable, String lastName);
}

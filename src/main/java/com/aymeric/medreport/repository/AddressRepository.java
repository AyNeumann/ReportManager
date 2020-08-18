package com.aymeric.medreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aymeric.medreport.model.Address;

/**
 * Customer address repository
 * @author Aymeric NEUMANN
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}

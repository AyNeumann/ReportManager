package com.aymeric.medreport.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.aymeric.medreport.dto.CustomerDTO;
import com.aymeric.medreport.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    
    /**
     * Map a Customer entity to a CustomerDTO 
     * @param customer Customer entity to map
     * @return a CustomerDto
     */
    CustomerDTO customerToCustomerDto(Customer customer);
    
    /**
     * Map a CustomerDTO to a Customer entity
     * @param customer CustomerDTO to map
     * @return a Customer entity
     */
    Customer customerDtoToCustomer(CustomerDTO customer);
    
    /**
     * Map a page of Customer entities to a page of Customer DTO
     * @param customers Customer entities to map
     * @return a page of CustomerDTO
     */
    default Page<CustomerDTO> customerPageToCustomerDtoPage(Page<Customer> customers) {
        return customers.map(this::customerToCustomerDto);
    }
    
    /**
     * Map a page of CustomerDTO to a page of Customer entities
     * @param customers CustomerDTO to map
     * @return a page of Customer entities
     */
    default Page<Customer> customerDtoPageToCustomerPage(Page<CustomerDTO> customers) {
        return customers.map(this::customerDtoToCustomer);
    }
}

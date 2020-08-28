package com.aymeric.medreport.utils;

import com.aymeric.medreport.dto.CustomerDTO;
import com.aymeric.medreport.model.Customer;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class CustomerEntityToDtoConveter implements Converter<Customer, CustomerDTO> {

    @Override
    public CustomerDTO convert(Customer value) {
        return new CustomerDTO(value.getId(), value.getLastName(), value.getFirstName(), value.getDateOfBirth(), value.getAddress(), value.getReports());
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
    
}

package com.aymeric.medreport.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.aymeric.medreport.model.Customer;
import com.aymeric.medreport.utils.CustomerMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = CustomerController.class)
public class CutomerControllerUnitTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CustomerMapper customerMapper;
    
    @MockBean
    CustomerController customerController;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    @Order(1)
    public void shouldMatchHttpRequest() throws Exception {
        mockMvc.perform(get("http://localhost:8080/customers/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
        
    }
    
    @Test
    @Order(2)
    public void shouldReturn200IfRequestBodyIsValid() throws JsonProcessingException, Exception {
        Customer customer = new Customer(1L, "Doe", "John", new Date(), null, null);
        
        mockMvc.perform(post("http://localhost:8080/customers/")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());
    }

}

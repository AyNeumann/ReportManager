package com.aymeric.medreport.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.aymeric.medreport.utils.CustomerMapper;

@WebMvcTest(controllers = CustomerController.class)
public class CutomerControllerUnitTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CustomerMapper customerMapper;
    
    @MockBean
    CustomerController customerController;
    
    @Test
    @Order(1)
    public void shouldMatchHttpRequest() throws Exception {
        mockMvc.perform(get("http://localhost:8080/customers/1")
                .contentType("application/json"))
                .andExpect(status().isOk());
        
    }

}

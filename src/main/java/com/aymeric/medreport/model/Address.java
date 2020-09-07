package com.aymeric.medreport.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * Customer address entity class
 * @author Aymeric NEUMANN
 *
 */
@Entity
public class Address implements Serializable {
    
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -8510767308006615873L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @NotBlank
    private String streetNumbers;
    
    @NotNull
    @NotBlank
    private String streetName;
    
    @NotNull
    @NotBlank
    private String zipCode;
    
    @NotNull
    @NotBlank
    private String city;
    
    @NotNull
    @NotBlank
    private String country;
    
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String details;
    
    @ManyToMany
    private List<Customer> customer;
    
    @Override
    public String toString() {
        return "Address [id=" + id + ", streetNumbers=" + streetNumbers + ", streetName=" + streetName + ", zipCode="
                + zipCode + ", city=" + city + ", country=" + country + ", details=" + details + "]";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the streetNumbers
     */
    public String getStreetNumbers() {
        return streetNumbers;
    }

    /**
     * @param streetNumbers the streetNumbers to set
     */
    public void setStreetNumbers(String streetNumbers) {
        this.streetNumbers = streetNumbers;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }
    
    /**
     * @return the customer
     */
    public List<Customer> getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
    
    
}

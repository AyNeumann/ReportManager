package com.aymeric.medreport.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.aymeric.medreport.model.Address;
import com.aymeric.medreport.model.Report;

/**
 * Customer entity data transfer object
 * @author Aymeric NEUMANN
 *
 */
public class CustomerDTO implements Serializable {
    
    /**
     * Generated Serial Version UID
     */
    private static final long serialVersionUID = -424922184856496007L;

    private Long id;
    
    private String lastName;
    
    private String firstName;
    
    private Date dateOfBirth;
    
    private List<Address> address;
    
    private List<Report> reports;
    
    public CustomerDTO() {}
    
    public CustomerDTO(Long id, String lastName, String firstName, Date dateOfBirth, List<Address> address, List<Report> reports) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.reports = reports;
    }

    /**
     * ToString override method
     */
    @Override
    public String toString() {
        return "Customer [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
                + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", reports=" + reports + "]";
    }
    
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * @return the reports
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}

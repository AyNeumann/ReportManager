package com.aymeric.medreport.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Customer entity class
 * @author Aymeric NEUMANN
 *
 */
@Entity
@NamedEntityGraph(name = "Customer.reports", attributeNodes = {
        @NamedAttributeNode("reports"),
        @NamedAttributeNode("address") 
})
public class Customer implements Serializable {
    
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 4504003902682243787L;

    /** Customer Id */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    /** Customer last name */
    @NotNull
    @NotBlank
    private String lastName;
    
    /** Customer first name */
    @NotNull
    @NotBlank
    private String firstName;
    
    /** Customer date of birth */
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    /** Customer addresses */
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    private List<Address> address;
    
    /** Customer reports */
    @OneToMany(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    private List<Report> reports;
    
    public Customer() {}
    
    public Customer(Long id, @NotNull @NotBlank String lastName, @NotNull @NotBlank String firstName, 
            @NotNull Date dateOfBirth, List<Address> address, List<Report> reports) {
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
                + ", dateOfBirth=" + dateOfBirth + "]";
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
     * @return the customerNumber
     */
    public Long getId() {
        return id;
    }
    
}

package com.aymeric.medreport.dto;

import java.util.Date;

public class CustomerInfoDTO {

    private Long id;
    
    private String lastName;
    
    private String firstName;

    private Date dateOfBirth;
    
    public CustomerInfoDTO() {}
    
    public CustomerInfoDTO(Long id, String lastName, String firstName, Date dateOfBirth) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "CustomerInfoDTO [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", dateOfBirth="
                + dateOfBirth + "]";
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
}

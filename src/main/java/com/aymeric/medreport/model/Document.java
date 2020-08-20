package com.aymeric.medreport.model;

import java.io.Serializable;
import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Document attached to a report class
 * @author Aymeric NEUMANN
 *
 */
@Entity
public class Document implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 6337017541382168795L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    @NotNull
    URL url;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the url
     */
    public URL getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(URL url) {
        this.url = url;
    }
}

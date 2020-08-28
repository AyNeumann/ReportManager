package com.aymeric.medreport.model;

import java.io.Serializable;
import java.net.URL;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    /** Document id */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    /** URL where the document is stocked */
    @NotNull
    URL url;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private Report report;
    
    /**
     * ToString override method
     */
    @Override
    public String toString() {
        return "Document [id=" + id + ", url=" + url + "]";
    }

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

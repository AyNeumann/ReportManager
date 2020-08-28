package com.aymeric.medreport.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.cache.annotation.Cacheable;

/**
 * Report entity class
 * @author Aymeric NEUMANN
 *
 */
@Entity
@Cacheable
public class Report implements Serializable {

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 5692543073666778733L;

    /** Report Id */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /** Report creation date */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    /** Report modification date */
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    /** Report title */
    @NotNull
    @NotBlank
    private String title;

    /* Report domain */
    @NotNull
    @Enumerated(EnumType.STRING)
    private Domain domain;

    /** Report status */
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    /** Report comments */
    @OneToMany(mappedBy="report", fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    private List<Comment> comment;

    /** Report attached documents */
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    private List<Document> documents;
    
    /** Customer who own the report */
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    
    /**
     * ToString override method
     */
    @Override
    public String toString() {
        return "Report [id=" + id + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
                + ", title=" + title + ", domain=" + domain + ", status=" + status + ", comment=" + comment
                + ", documents=" + documents + "]";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the modificationDate
     */
    public Date getModificationDate() {
        return modificationDate;
    }

    /**
     * @param modificationDate the modificationDate to set
     */
    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the domain
     */
    public Domain getDomain() {
        return domain;
    }

    /**
     * @param domain the domain to set
     */
    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * @return the comment
     */
    public List<Comment> getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}

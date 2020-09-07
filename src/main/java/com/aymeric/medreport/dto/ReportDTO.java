package com.aymeric.medreport.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.aymeric.medreport.model.Comment;
import com.aymeric.medreport.model.Document;
import com.aymeric.medreport.model.Domain;
import com.aymeric.medreport.model.Status;

/**
 * Report entity data transfer object
 * @author Aymeric NEUMANN
 *
 */
public class ReportDTO implements Serializable {
    
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = -3393678786740772674L;

    private Long id;

    private Date creationDate;

    private Date modificationDate;

    private String title;

    private Domain domain;

    private Status status;

    private List<Comment> comment;

    private List<Document> documents;
    
    /**
     * ToString override method
     */
    @Override
    public String toString() {
        return "ReportDTO [id=" + id + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
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
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
}

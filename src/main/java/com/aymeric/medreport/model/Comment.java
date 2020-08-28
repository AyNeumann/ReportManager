package com.aymeric.medreport.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * Report comment entity class
 * @author Aymeric NEUMANN
 *
 */
@Entity
public class Comment implements Serializable {
    
    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 8653437506466912925L;

    /** Comment id */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    /** Comment creation date */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    
    /** Comment modification date */
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    
    /** Comment contents */
    @Lob
    @NotNull
    @NotBlank
    @Type(type = "org.hibernate.type.TextType")
    private String commentText;
    
    @ManyToOne
    @JoinColumn(name = "id_report")
    private Report report;
    
    /**
     * ToString override method
     */
    @Override
    public String toString() {
        return "Comment [id=" + id + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate
                + ", commentText=" + commentText + "]";
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
     * @return the commentText
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * @param commentText the commentText to set
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
    
}

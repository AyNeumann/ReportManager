package com.aymeric.medreport.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

/**
 * Report comment entity class
 * @author Aymeric NEUMANN
 *
 */
@Entity
public class Comment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private Date creationDate;
    
    private Date modificationDate;
    
    @Lob
    @NotNull
    @NotBlank
    @Type(type = "org.hibernate.type.TextType")
    private String commentText;
    
    @Override
    public String toString() {
        return "Comment [id=" + id + ", modificationDate=" + modificationDate + ", creationDate=" + creationDate
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

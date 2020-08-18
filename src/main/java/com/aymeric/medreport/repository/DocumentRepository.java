package com.aymeric.medreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aymeric.medreport.model.Document;

/**
 * Document attached to a report repository
 * @author Aymeric NEUMANN
 *
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

}

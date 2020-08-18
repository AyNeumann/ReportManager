package com.aymeric.medreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aymeric.medreport.model.Comment;

/**
 * Report comments repository
 * @author Aymeric NEUMANN
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}

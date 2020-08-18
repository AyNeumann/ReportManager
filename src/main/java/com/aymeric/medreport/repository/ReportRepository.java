package com.aymeric.medreport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aymeric.medreport.model.Report;

/**
 * Report repository
 * @author Aymeric NEUMANN
 *
 */
public interface ReportRepository extends JpaRepository<Report, Long>{

}

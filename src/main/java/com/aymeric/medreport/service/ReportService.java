package com.aymeric.medreport.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aymeric.medreport.dto.MedReportEntityExceptionDTO;
import com.aymeric.medreport.model.Report;
import com.aymeric.medreport.repository.ReportRepository;

/**
 * Report service class
 * @author Aymeric NEUMANN
 *
 */
@Service
public class ReportService {
    
    /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);
    
    /** Reference to the report repository */
    @Autowired
    ReportRepository reportRepository;
    
    /**
     * Create a report
     * @param report report to create
     * @return created report
     */
    public Report createReport(final Report report) {
        logger.debug("Saving the report: {}", report);
        return reportRepository.save(report);
    }
    
    /**
     * Get a report by Id
     * @param id id id of the report to get
     * @return the found report or a MedReportEntityExceptionDTO
     */
    public Report getReportById(final long id) {
        Optional<Report> report = reportRepository.findById(id);
        
        if(!report.isPresent()) {
            String errMessage = String.format("No report found with the id: %s", id);
            logger.info(errMessage);
            throw new MedReportEntityExceptionDTO(errMessage);
        }
        
        return report.get();
    }
}

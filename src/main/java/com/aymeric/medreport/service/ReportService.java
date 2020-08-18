package com.aymeric.medreport.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Report getReportById(final long id) {
        Optional<Report> report = reportRepository.findById(id);
        
        if(!report.isPresent()) {
            logger.info("No report found with the id: {}", id);
            //TODO: throw exception
        }
        
        return report.get();
    }
}

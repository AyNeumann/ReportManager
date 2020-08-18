package com.aymeric.medreport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aymeric.medreport.model.Report;
import com.aymeric.medreport.service.ReportService;

import io.swagger.annotations.ApiOperation;

/**
 * Report Controller manage request about reports
 * @author Aymeric NEUMANN
 *
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
    
    /** Reference to report service class */
    @Autowired
    private ReportService reportService;
    
    /**
     * Get a report by Id
     * @param id id of the report to get
     * @return the found report or ??
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get report by Id", notes = "Getting a report by his id", response = Report.class)
    public Report getById(@RequestParam(name = "id") final Long id) {
        logger.debug("Getting report with the id: {}", id);
        return reportService.getReportById(id);
    }
    
}

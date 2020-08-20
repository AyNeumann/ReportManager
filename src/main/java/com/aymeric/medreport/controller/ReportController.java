package com.aymeric.medreport.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aymeric.medreport.dto.MedReportEntityExceptionDTO;
import com.aymeric.medreport.model.Report;
import com.aymeric.medreport.service.ReportService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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
     * Create a report
     * @param report report to create
     * @return created report
     */
    @PostMapping("")
    @ApiOperation(value = "Create a report", notes = "Save a report in the database")
    public Report create(@RequestBody Report report) {
        logger.debug("Saving the report: {}", report);
        return reportService.createReport(report);
    }
    
    /**
     * Get a report by Id
     * @param id id of the report to get
     * @return the found report or a MedReportEntityExceptionDTO
     */
    @GetMapping("/byId")
    @ApiOperation(value = "Get report by Id", notes = "Getting a report by his id")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, response = Report.class, message = "Success"),
            @ApiResponse(code = 400, response = MedReportEntityExceptionDTO.class, message = "Bad Request")
            }
    )
    public Report getById(@RequestParam(name = "id") final Long id) {
        logger.debug("Getting report with the id: {}", id);
        return reportService.getReportById(id);
    }
    
}

package com.aymeric.medreport.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aymeric.medreport.dto.MedReportEntityExceptionDTO;
import com.aymeric.medreport.dto.ReportDTO;
import com.aymeric.medreport.model.Report;
import com.aymeric.medreport.service.ReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Report Controller manage request about reports
 * @author Aymeric NEUMANN
 *
 */
@RestController
@RequestMapping("/reports")
@Api(value = "Report Controller")
public class ReportController {

    /** Logback logger reference. */
    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);
    
    /** Reference to report service class */
    @Autowired
    private ReportService reportService;
    
    /** Model mapper reference. */
    @Autowired
    private ModelMapper modelMapper;
    
    /**
     * Create a report
     * @param report report to create
     * @return created report
     */
    @PostMapping("")
    @ApiOperation(value = "Create a report", notes = "Save a report in the database")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, response = ReportDTO.class, message = "Success")
    })
    public ReportDTO create(@RequestBody ReportDTO reportDto) {
        logger.debug("Saving the report: {}", reportDto);
        
        Report report = convertToEntity(reportDto);
        
        return convertToDto(reportService.createReport(report));
    }
    
    /**
     * Get a report by Id
     * @param id id of the report to get
     * @return the found report or a MedReportEntityExceptionDTO
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "Get report by Id", notes = "Getting a report by his id")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, response = Report.class, message = "Success"),
            @ApiResponse(code = 400, response = MedReportEntityExceptionDTO.class, message = "Bad Request")
            }
    )
    public ReportDTO getById(@PathVariable final Long id) {
        logger.debug("Getting report with the id: {}", id);
        return convertToDto(reportService.getReportById(id));
    }
    
    /**
     * Convert Report Entity to Report DTO class
     * @param report Report Entity to convert
     * @return a ReportDTO
     */
    private ReportDTO convertToDto(final Report report) {
        return modelMapper.map(report, ReportDTO.class);
    }
    
    /**
     * Convert ReportDTO class to a Report Entity
     * @param reportDTO ReportDTO to convert
     * @return a Customer Entity
     */
    private Report convertToEntity(final ReportDTO reportDTO) {
        return modelMapper.map(reportDTO, Report.class);
    }
    
}

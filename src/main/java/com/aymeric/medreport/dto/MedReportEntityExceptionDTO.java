package com.aymeric.medreport.dto;

import java.util.Date;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModelProperty;
/**
 * Custom Report Manager Entity Exception DTO 
 * @author Aymeric NEUMANN
 *
 */
public class MedReportEntityExceptionDTO extends RuntimeException {

    /**
     * Generated Serial Default UID.
     */
    private static final long serialVersionUID = 4131490202372475531L;
    
    /** Exception HTTP status number */
    @ApiModelProperty(notes = "Exception HTTP status number", name="httpErrorNumber", required=false, example="400")
    private HttpStatus httpErrorNumber;
    
    /** Date when the exception occurred */
    @ApiModelProperty(notes = "Date when the exception occurred", name="timeStamp", required=false, value="")
    private Date timeStamp;
    
    /**
     * Default MedReportEntityException constructor
     * @param message exception message
     */
    public MedReportEntityExceptionDTO(final String message) {
        super(message);
    }
    
    /**
     * MedReportEntityException constructor with message HTTP status and time stamp.
     * @param message exception message
     * @param badRequest exception HTTP status
     * @param date exception time stamp
     */
    public MedReportEntityExceptionDTO(final String message, final HttpStatus badRequest, final Date date) {
        super(message);
        this.httpErrorNumber = badRequest;
        this.timeStamp = date;
    }
    
    /**
     * @return the httpErrorNumber
     */
    public HttpStatus getHttpErrorNumber() {
        return httpErrorNumber;
    }

    /**
     * @param httpErrorNumber the httpErrorNumber to set
     */
    public void setHttpErrorNumber(final HttpStatus httpErrorNumber) {
        this.httpErrorNumber = httpErrorNumber;
    }

    /**
     * @return the timeStamp
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(final Date timeStamp) {
        this.timeStamp = timeStamp;
    }

}

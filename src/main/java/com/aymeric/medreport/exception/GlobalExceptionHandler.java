package com.aymeric.medreport.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aymeric.medreport.dto.MedReportEntityExceptionDTO;

/**
 * Handle exceptions
 * @author Aymeric NEUMANN
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MedReportEntityExceptionDTO.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<MedReportEntityExceptionDTO> handleAapiEntityException(final MedReportEntityExceptionDTO ex) {
        MedReportEntityExceptionDTO exception = new MedReportEntityExceptionDTO(ex.getMessage(), HttpStatus.BAD_REQUEST, new Date());
        return new ResponseEntity<>(exception, exception.getHttpErrorNumber());
    }
}

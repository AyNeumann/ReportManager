package com.aymeric.medreport.utils;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.aymeric.medreport.dto.ReportDTO;
import com.aymeric.medreport.model.Report;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    ReportMapper INSTANCE = Mappers.getMapper( ReportMapper.class );
    
    /**
     * Map a Report entity to a ReportDTO
     * @param report Report entity to map
     * @return a ReportDTO
     */
    ReportDTO reportToReportDTO(Report report);
    
    /**
     * Map a ReportDTO to a Report entity
     * @param report ReportDTO to map
     * @return a Report entity
     */
    Report reportDtoToReport(ReportDTO report);
    
    /**
     * Map a page of Report entities to a page of ReportDTO
     * @param reports Report entities to map
     * @return a page of ReportDTO
     */
    default Page<ReportDTO> reportPageToReportDtoPage(Page<Report> reports) {
        return reports.map(this::reportToReportDTO);
    }
    
    /**
     * Map a page ReportDTO to a page of Report entities
     * @param reports ReportDTO to map
     * @return a Page of Report entities
     */
    default Page<Report> reportDtoPageToReportPage(Page<ReportDTO> reports) {
        return reports.map(this::reportDtoToReport);
    }
}

package com.hotelmanagement.dto;

import com.hotelmanagement.service.report.ReportFactory;
import java.time.LocalDateTime;

public class ReportRequest {
    public ReportFactory.ReportingType type;
    public LocalDateTime start;
    public LocalDateTime end;
}

package com.hotelmanagement.service.report;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ReportExportService {
    public String exportToCsv(Map<String, Object> data) {
        // demo: thực tế ghi file CSV/PDF
        return "exported_report.csv";
    }

    public String export(IReport report, LocalDateTime start, LocalDateTime end) {
        Map<String, Object> data = report.generateData(start, end);
        return exportToCsv(data);
    }
}

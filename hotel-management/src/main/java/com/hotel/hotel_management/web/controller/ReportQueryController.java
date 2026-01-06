package com.hotelmanagement.web.controller;

import com.hotelmanagement.dto.ReportRequest;
import com.hotelmanagement.service.report.ReportExportService;
import com.hotelmanagement.service.report.ReportFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportQueryController {
    private final ReportFactory factory;
    private final ReportExportService exportService;

    public ReportQueryController(ReportFactory factory, ReportExportService exportService) {
        this.factory = factory;
        this.exportService = exportService;
    }

    @PostMapping("/export")
    public ResponseEntity<String> export(@RequestBody ReportRequest req) {
        var report = factory.createReport(req.type);
        String file = exportService.export(report, req.start, req.end);
        return ResponseEntity.ok(file);
    }
}

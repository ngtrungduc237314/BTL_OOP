package com.hotelmanagement.web.controller;

import com.hotelmanagement.service.report.ReportFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report-factory")
public class ReportFactoryController {

    private final ReportFactory reportFactory;

    public ReportFactoryController(ReportFactory reportFactory) {
        this.reportFactory = reportFactory;
    }

    /**
     * Demo: tạo report instance bằng factory.
     * Ví dụ: GET /api/report-factory/create?type=REVENUE
     */
    @GetMapping("/create")
    public ResponseEntity<String> create(@RequestParam ReportFactory.ReportingType type) {
        var report = reportFactory.createReport(type);
        return ResponseEntity.ok("Created report instance: " + report.getClass().getSimpleName());
    }
}

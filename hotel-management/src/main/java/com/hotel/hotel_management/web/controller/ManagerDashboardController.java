package com.hotelmanagement.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
public class ManagerDashboardController {

    @GetMapping("/dashboard")
    public ResponseEntity<String> dashboard() {
        return ResponseEntity.ok("""
                MANAGER DASHBOARD:
                - Reports: /api/reports/export
                - Compare branches: /api/comparison/branches?branchIds=1,2,3
                """);
    }

    @GetMapping("/navigate/{page}")
    public ResponseEntity<String> navigate(@PathVariable String page) {
        // mô phỏng chức năng "navigate..." trong UML
        return ResponseEntity.ok("Navigate to: " + page);
    }
}

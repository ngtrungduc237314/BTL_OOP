package com.hotelmanagement.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comparison")
public class ComparisonController {

    /**
     * Demo so sánh các chi nhánh.
     * Ví dụ: GET /api/comparison/branches?branchIds=1,2,3
     */
    @GetMapping("/branches")
    public ResponseEntity<String> compareBranches(@RequestParam String branchIds) {
        List<Integer> ids = Arrays.stream(branchIds.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Demo: thực tế sẽ gọi ReportService/Repository để lấy số liệu
        return ResponseEntity.ok("Compare branches: " + ids);
    }
}

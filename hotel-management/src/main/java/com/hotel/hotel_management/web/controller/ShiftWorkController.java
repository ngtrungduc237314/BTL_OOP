package com.hotelmanagement.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/shift")
public class ShiftWorkController {

    /**
     * Bắt đầu ca, nhập tiền mặt đầu ca (nếu có).
     * Ví dụ: POST /api/shift/start?initialCash=500000
     */
    @PostMapping("/start")
    public ResponseEntity<String> startShift(@RequestParam(defaultValue = "0") BigDecimal initialCash) {
        return ResponseEntity.ok("Shift started. Initial cash = " + initialCash);
    }

    /**
     * Kết thúc ca, chốt tiền.
     * Ví dụ: POST /api/shift/end?finalCash=1200000
     */
    @PostMapping("/end")
    public ResponseEntity<String> endShift(@RequestParam(defaultValue = "0") BigDecimal finalCash) {
        return ResponseEntity.ok("Shift ended. Final cash = " + finalCash);
    }

    /**
     * Sinh báo cáo ca (demo).
     */
    @GetMapping("/report")
    public ResponseEntity<String> shiftReport() {
        return ResponseEntity.ok("Shift report (demo).");
    }
}

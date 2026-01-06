package com.hotelmanagement.web.controller;

import com.hotelmanagement.domain.entity.Booking;
import com.hotelmanagement.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/checkin")
public class CheckInController {

    private final BookingService bookingService;

    public CheckInController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Xác nhận check-in cho một booking.
     * Ví dụ: POST /api/checkin/12?date=2026-01-06
     */
    @PostMapping("/{bookingId}")
    public ResponseEntity<Booking> confirmCheckin(
            @PathVariable Long bookingId,
            @RequestParam(required = false) LocalDate date
    ) {
        LocalDate actual = (date != null) ? date : LocalDate.now();
        return ResponseEntity.ok(bookingService.confirmCheckin(bookingId, actual));
    }
}

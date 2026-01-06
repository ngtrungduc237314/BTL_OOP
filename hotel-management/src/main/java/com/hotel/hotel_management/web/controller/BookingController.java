package com.hotelmanagement.web.controller;

import com.hotelmanagement.dto.BookingRequest;
import com.hotelmanagement.domain.entity.Booking;
import com.hotelmanagement.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingRequest req) {
        return ResponseEntity.ok(
                bookingService.createBooking(req.customerId, req.roomId, req.checkin, req.checkout)
        );
    }

    @PostMapping("/{id}/checkin")
    public ResponseEntity<Booking> checkin(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.confirmCheckin(id, java.time.LocalDate.now()));
    }
}

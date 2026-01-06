package com.hotelmanagement.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reception")
public class ReceptionController {

    /**
     * Endpoint “menu” mô phỏng nhóm tác vụ lễ tân.
     * Anh có thể tách tiếp thành RoomController/CustomerController/BookingController nếu muốn.
     */
    @GetMapping("/menu")
    public ResponseEntity<String> menu() {
        return ResponseEntity.ok("""
                RECEPTION MENU:
                - /api/bookings (CRUD Booking)
                - /api/checkin/{bookingId}
                - /api/checkout
                - /api/rooms (nếu tách RoomController)
                """);
    }
}

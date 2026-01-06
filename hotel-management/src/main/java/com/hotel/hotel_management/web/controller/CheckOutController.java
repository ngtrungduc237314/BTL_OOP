package com.hotelmanagement.web.controller;

import com.hotelmanagement.dto.PaymentRequest;
import com.hotelmanagement.domain.entity.Invoice;
import com.hotelmanagement.service.checkout.CheckOutFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {
    private final CheckOutFacade facade;

    public CheckOutController(CheckOutFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public ResponseEntity<Invoice> checkout(@RequestBody PaymentRequest req) {
        return ResponseEntity.ok(
                facade.processCheckout(req.bookingId, req.paymentType, req.actualCheckout)
        );
    }
}

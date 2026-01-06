package com.hotelmanagement.service.approval;

import com.hotelmanagement.service.BookingService;

public class RejectRequestCmd implements ICommand {
    private final Long bookingId;
    private final String reason;
    private final BookingService bookingService;

    public RejectRequestCmd(Long bookingId, String reason, BookingService bookingService) {
        this.bookingId = bookingId;
        this.reason = reason;
        this.bookingService = bookingService;
    }

    @Override
    public void execute() {
        System.out.println("Rejected booking " + bookingId + " because: " + reason);
    }
}

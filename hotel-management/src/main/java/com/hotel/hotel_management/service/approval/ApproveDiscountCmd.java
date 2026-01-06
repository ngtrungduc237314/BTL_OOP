package com.hotelmanagement.service.approval;

import com.hotelmanagement.service.BookingService;

public class ApproveDiscountCmd implements ICommand {
    private final Long bookingId;
    private final int discountPercent;
    private final BookingService bookingService;

    public ApproveDiscountCmd(Long bookingId, int discountPercent, BookingService bookingService) {
        this.bookingId = bookingId;
        this.discountPercent = discountPercent;
        this.bookingService = bookingService;
    }

    @Override
    public void execute() {
        // demo: thực tế sẽ cập nhật booking/ invoice
        System.out.println("Approved discount " + discountPercent + "% for booking " + bookingId);
    }
}

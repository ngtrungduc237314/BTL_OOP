package com.hotelmanagement.dto;

import java.time.LocalDate;

public class BookingRequest {
    public Long customerId;
    public Long roomId;
    public LocalDate checkin;
    public LocalDate checkout;
}

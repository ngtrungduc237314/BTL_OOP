package com.hotelmanagement.dto;

import com.hotelmanagement.domain.enums.PaymentType;
import java.time.LocalDate;

public class PaymentRequest {
    public Long bookingId;
    public PaymentType paymentType;
    public LocalDate actualCheckout;
}

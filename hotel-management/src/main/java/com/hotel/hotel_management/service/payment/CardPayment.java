package com.hotelmanagement.service.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CardPayment implements IPaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paid by CARD: " + amount);
    }
}

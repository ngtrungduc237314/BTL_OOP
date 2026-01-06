package com.hotelmanagement.service.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CashPayment implements IPaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        // demo
        System.out.println("Paid by CASH: " + amount);
    }
}

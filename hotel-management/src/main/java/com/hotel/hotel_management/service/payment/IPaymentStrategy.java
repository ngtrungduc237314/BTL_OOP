package com.hotelmanagement.service.payment;

import java.math.BigDecimal;

public interface IPaymentStrategy {
    void pay(BigDecimal amount);
}

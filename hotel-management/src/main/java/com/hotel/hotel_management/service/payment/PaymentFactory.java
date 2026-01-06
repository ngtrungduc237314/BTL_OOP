package com.hotelmanagement.service.payment;

import com.hotelmanagement.domain.enums.PaymentType;
import org.springframework.stereotype.Service;

@Service
public class PaymentFactory {
    private final CashPayment cash;
    private final CardPayment card;
    private final BankTransferPayment bank;

    public PaymentFactory(CashPayment cash, CardPayment card, BankTransferPayment bank) {
        this.cash = cash;
        this.card = card;
        this.bank = bank;
    }

    public IPaymentStrategy getPaymentStrategy(PaymentType type) {
        return switch (type) {
            case CASH -> cash;
            case CREDIT_CARD -> card;
            case BANK_TRANSFER -> bank;
        };
    }
}

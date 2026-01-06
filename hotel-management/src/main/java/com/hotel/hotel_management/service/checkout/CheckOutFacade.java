package com.hotelmanagement.service.checkout;

import com.hotelmanagement.domain.entity.Booking;
import com.hotelmanagement.domain.entity.Invoice;
import com.hotelmanagement.domain.enums.PaymentType;
import com.hotelmanagement.repository.InvoiceRepository;
import com.hotelmanagement.service.BookingService;
import com.hotelmanagement.service.payment.PaymentFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CheckOutFacade {
    private final BookingService bookingService;
    private final InvoiceRepository invoiceRepo;
    private final PaymentFactory paymentFactory;

    public CheckOutFacade(BookingService bookingService, InvoiceRepository invoiceRepo, PaymentFactory paymentFactory) {
        this.bookingService = bookingService;
        this.invoiceRepo = invoiceRepo;
        this.paymentFactory = paymentFactory;
    }

    public Invoice processCheckout(Long bookingId, PaymentType paymentType, LocalDate actualCheckout) {
        Booking b = bookingService.confirmCheckout(bookingId, actualCheckout);

        Invoice inv = new Invoice(b);
        inv.setRoomTotalAmount(BigDecimal.valueOf(100)); // demo
        inv.setPaymentType(paymentType);

        Invoice saved = invoiceRepo.save(inv);

        paymentFactory.getPaymentStrategy(paymentType).pay(saved.getGrandTotal());
        return saved;
    }
}

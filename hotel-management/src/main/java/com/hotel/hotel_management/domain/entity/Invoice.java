package com.hotelmanagement.domain.entity;

import com.hotelmanagement.domain.enums.PaymentType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Booking booking;

    private BigDecimal roomTotalAmount = BigDecimal.ZERO;
    private BigDecimal additionalRoomCharge = BigDecimal.ZERO;
    private BigDecimal serviceFee = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Invoice() {}

    public Invoice(Booking booking) {
        this.booking = booking;
    }

    public Long getId() { return id; }
    public Booking getBooking() { return booking; }
    public BigDecimal getRoomTotalAmount() { return roomTotalAmount; }
    public BigDecimal getAdditionalRoomCharge() { return additionalRoomCharge; }
    public BigDecimal getServiceFee() { return serviceFee; }
    public PaymentType getPaymentType() { return paymentType; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public BigDecimal getGrandTotal() {
        return roomTotalAmount.add(additionalRoomCharge).add(serviceFee);
    }

    public void setRoomTotalAmount(BigDecimal v) { this.roomTotalAmount = v; }
    public void setAdditionalRoomCharge(BigDecimal v) { this.additionalRoomCharge = v; }
    public void setServiceFee(BigDecimal v) { this.serviceFee = v; }
    public void setPaymentType(PaymentType paymentType) { this.paymentType = paymentType; }
}

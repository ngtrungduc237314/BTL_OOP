package com.hotelmanagement.domain.entity;

import com.hotelmanagement.domain.enums.BookingStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Customer customer;

    @ManyToOne(optional = false)
    private Room room;

    private LocalDate expectedCheckinDate;
    private LocalDate expectedCheckoutDate;

    private LocalDate actualCheckinDate;
    private LocalDate actualCheckoutDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.BOOKED;

    public Booking() {}

    public Booking(Customer customer, Room room, LocalDate expectedCheckinDate, LocalDate expectedCheckoutDate) {
        this.customer = customer;
        this.room = room;
        this.expectedCheckinDate = expectedCheckinDate;
        this.expectedCheckoutDate = expectedCheckoutDate;
    }

    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public LocalDate getExpectedCheckinDate() { return expectedCheckinDate; }
    public LocalDate getExpectedCheckoutDate() { return expectedCheckoutDate; }
    public LocalDate getActualCheckinDate() { return actualCheckinDate; }
    public LocalDate getActualCheckoutDate() { return actualCheckoutDate; }
    public BookingStatus getStatus() { return status; }

    public void setStatus(BookingStatus status) { this.status = status; }
    public void setActualCheckinDate(LocalDate d) { this.actualCheckinDate = d; }
    public void setActualCheckoutDate(LocalDate d) { this.actualCheckoutDate = d; }
}

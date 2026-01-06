package com.hotelmanagement.service;

import com.hotelmanagement.domain.entity.Booking;
import com.hotelmanagement.domain.entity.Customer;
import com.hotelmanagement.domain.entity.Room;
import com.hotelmanagement.domain.enums.BookingStatus;
import com.hotelmanagement.domain.enums.RoomStatus;
import com.hotelmanagement.repository.BookingRepository;
import com.hotelmanagement.repository.CustomerRepository;
import com.hotelmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {
    private final BookingRepository bookingRepo;
    private final RoomRepository roomRepo;
    private final CustomerRepository customerRepo;

    public BookingService(BookingRepository bookingRepo, RoomRepository roomRepo, CustomerRepository customerRepo) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.customerRepo = customerRepo;
    }

    public Booking createBooking(Long customerId, Long roomId, LocalDate checkin, LocalDate checkout) {
        Customer c = customerRepo.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        Room r = roomRepo.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        Booking b = new Booking(c, r, checkin, checkout);
        return bookingRepo.save(b);
    }

    public Booking confirmCheckin(Long bookingId, LocalDate actualCheckin) {
        Booking b = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        b.setActualCheckinDate(actualCheckin);
        b.setStatus(BookingStatus.CHECKED_IN);

        // cập nhật phòng
        Room r = b.getRoom();
        r.setStatus(RoomStatus.OCCUPIED);
        roomRepo.save(r);

        return bookingRepo.save(b);
    }

    public Booking confirmCheckout(Long bookingId, LocalDate actualCheckout) {
        Booking b = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        b.setActualCheckoutDate(actualCheckout);
        b.setStatus(BookingStatus.CHECKED_OUT);

        // trả phòng => dirty
        Room r = b.getRoom();
        r.setStatus(RoomStatus.DIRTY);
        roomRepo.save(r);

        return bookingRepo.save(b);
    }
}

package com.hotelmanagement.repository;

import com.hotelmanagement.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}

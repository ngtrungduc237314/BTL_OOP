package com.hotelmanagement.service;

import com.hotelmanagement.domain.entity.Room;
import com.hotelmanagement.domain.enums.RoomStatus;
import com.hotelmanagement.domain.enums.RoomType;
import com.hotelmanagement.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepo;

    public RoomService(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room createRoom(String roomNumber, RoomType type, BigDecimal pricePerNight) {
        Room r = new Room(roomNumber, type, pricePerNight);
        return roomRepo.save(r);
    }

    public List<Room> listRooms() {
        return roomRepo.findAll();
    }

    public Room updateStatus(Long roomId, RoomStatus status) {
        Room r = roomRepo.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
        r.setStatus(status);
        return roomRepo.save(r);
    }
}

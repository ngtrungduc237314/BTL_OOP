package com.hotelmanagement.domain.entity;

import com.hotelmanagement.domain.enums.RoomStatus;
import com.hotelmanagement.domain.enums.RoomType;
import com.hotelmanagement.domain.observer.IObserver;
import com.hotelmanagement.domain.observer.ISubject;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room implements ISubject {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomStatus status = RoomStatus.AVAILABLE;

    @Column(nullable = false)
    private BigDecimal pricePerNight;

    @Transient
    private final List<IObserver> observers = new ArrayList<>();

    public Room() {}

    public Room(String roomNumber, RoomType type, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public Long getId() { return id; }
    public String getRoomNumber() { return roomNumber; }
    public RoomType getType() { return type; }
    public RoomStatus getStatus() { return status; }
    public BigDecimal getPricePerNight() { return pricePerNight; }

    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void setType(RoomType type) { this.type = type; }
    public void setPricePerNight(BigDecimal pricePerNight) { this.pricePerNight = pricePerNight; }

    public void setStatus(RoomStatus newStatus) {
        this.status = newStatus;
        notifyObservers("Room " + roomNumber + " changed status to " + newStatus);
    }

    @Override public void attach(IObserver observer) { observers.add(observer); }
    @Override public void detach(IObserver observer) { observers.remove(observer); }
    @Override public void notifyObservers(String message) {
        for (IObserver o : observers) o.update(message);
    }
}

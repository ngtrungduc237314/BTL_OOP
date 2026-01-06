package com.hotelmanagement.web.controller;

import com.hotelmanagement.domain.entity.Room;
import com.hotelmanagement.domain.enums.RoomStatus;
import com.hotelmanagement.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/housekeeping")
public class HousekeepingController {

    private final RoomService roomService;

    public HousekeepingController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Đánh dấu phòng từ DIRTY -> AVAILABLE sau khi dọn xong.
     * Ví dụ: POST /api/housekeeping/rooms/5/mark-clean
     */
    @PostMapping("/rooms/{roomId}/mark-clean")
    public ResponseEntity<Room> markClean(@PathVariable Long roomId) {
        // dọn xong => AVAILABLE
        return ResponseEntity.ok(roomService.updateStatus(roomId, RoomStatus.AVAILABLE));
    }

    /**
     * Đánh dấu phòng vào bảo trì.
     * Ví dụ: POST /api/housekeeping/rooms/5/maintenance
     */
    @PostMapping("/rooms/{roomId}/maintenance")
    public ResponseEntity<Room> setMaintenance(@PathVariable Long roomId) {
        return ResponseEntity.ok(roomService.updateStatus(roomId, RoomStatus.MAINTENANCE));
    }
}

package com.hotelmanagement.service.report;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class OccupancyReport implements IReport {
    @Override
    public Map<String, Object> generateData(LocalDateTime start, LocalDateTime end) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", "OCCUPANCY");
        data.put("start", start);
        data.put("end", end);
        data.put("occupancyRate", 0.76); // demo
        return data;
    }
}

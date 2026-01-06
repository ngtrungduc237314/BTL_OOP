package com.hotelmanagement.service.report;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class RevenueReport implements IReport {
    @Override
    public Map<String, Object> generateData(LocalDateTime start, LocalDateTime end) {
        Map<String, Object> data = new HashMap<>();
        data.put("type", "REVENUE");
        data.put("start", start);
        data.put("end", end);
        data.put("totalRevenue", 123456); // demo
        return data;
    }
}

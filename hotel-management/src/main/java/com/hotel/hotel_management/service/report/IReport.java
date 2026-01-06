package com.hotelmanagement.service.report;

import java.time.LocalDateTime;
import java.util.Map;

public interface IReport {
    Map<String, Object> generateData(LocalDateTime start, LocalDateTime end);
}

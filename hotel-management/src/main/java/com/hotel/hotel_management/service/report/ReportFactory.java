package com.hotelmanagement.service.report;

import org.springframework.stereotype.Service;

@Service
public class ReportFactory {
    private final RevenueReport revenue;
    private final OccupancyReport occupancy;

    public enum ReportingType { REVENUE, OCCUPANCY }

    public ReportFactory(RevenueReport revenue, OccupancyReport occupancy) {
        this.revenue = revenue;
        this.occupancy = occupancy;
    }

    public IReport createReport(ReportingType type) {
        return switch (type) {
            case REVENUE -> revenue;
            case OCCUPANCY -> occupancy;
        };
    }
}

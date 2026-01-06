package com.hotelmanagement.common.config;

import java.time.LocalTime;

public final class SystemConfig {
    private SystemConfig() {}

    // ví dụ cấu hình chuẩn hóa giờ checkin/checkout
    public static final LocalTime STANDARD_CHECKIN_TIME = LocalTime.of(14, 0);
    public static final LocalTime STANDARD_CHECKOUT_TIME = LocalTime.of(12, 0);
}

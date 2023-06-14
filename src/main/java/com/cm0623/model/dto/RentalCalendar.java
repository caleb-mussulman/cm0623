package com.cm0623.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RentalCalendar {
    private LocalDate checkoutDate;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private Integer rentalDayCount;
    private Integer holidayCount;
    private Integer weekdayCount;
    private Integer weekendCount;
}

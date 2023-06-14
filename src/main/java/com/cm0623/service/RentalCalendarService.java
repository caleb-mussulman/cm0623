package com.cm0623.service;

import com.cm0623.model.dto.RentalCalendar;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

@Service
public class RentalCalendarService {

    public RentalCalendar constructRentalCalendar(LocalDate checkoutDate, @Min(value = 1, message = "Please provide an integer value greater than or equal to 1") Integer rentalDayCount) {
        int holidayCount = 0;
        int weekdayCount = 0;
        int weekendCount = 0;

        // rental charges start one day after checkout date
        LocalDate rentalStartDate = checkoutDate.plus(1, ChronoUnit.DAYS);
        LocalDate rentalEndDate = checkoutDate.plus(rentalDayCount, ChronoUnit.DAYS);

        // add a day to make the range inclusive of the last day
        List<LocalDate> days = rentalStartDate.datesUntil(rentalEndDate.plus(1, ChronoUnit.DAYS)).toList();

        // a given rental day is either a holiday (based on the definition for a holiday), weekday, or weekend
        for(LocalDate day : days) {
            if(isHoliday(day)) {
                holidayCount++;
            } else if(isWeekday(day)) {
                weekdayCount++;
            } else {
                weekendCount++;
            }
        }

        RentalCalendar rentalCalendar = new RentalCalendar();
        rentalCalendar.setCheckoutDate(checkoutDate);
        rentalCalendar.setRentalStartDate(rentalStartDate);
        rentalCalendar.setRentalEndDate(rentalEndDate);
        rentalCalendar.setRentalDayCount(rentalDayCount);
        rentalCalendar.setHolidayCount(holidayCount);
        rentalCalendar.setWeekdayCount(weekdayCount);
        rentalCalendar.setWeekendCount(weekendCount);
        return rentalCalendar;
    }

    private boolean isHoliday(LocalDate day) {
        return isIndependenceDay(day) || isLaborDay(day);
    }

    private boolean isIndependenceDay(LocalDate day) {
        // If July 4th falls on a weekday, then it is observed as a holiday;
        // If July 4th falls on the weekend, then the closest weekday is observed:
        // So, July 3rd on a Friday is a holiday,
        // and July 5th on a Monday is a holiday
        if(Month.JULY.equals(day.getMonth())) {
            if (day.getDayOfMonth() == 4 && isWeekday(day)) {
                return true;
            }
            if (day.getDayOfMonth() == 3 && DayOfWeek.FRIDAY.equals(DayOfWeek.from(day))) {
                return true;
            }
            if (day.getDayOfMonth() == 5 && DayOfWeek.MONDAY.equals(DayOfWeek.from(day))) {
                return true;
            }
        }
        return false;
    }

    private boolean isLaborDay(LocalDate day) {
        // If the current date is in September and the first monday of the month is also the current date,
        // then the day is Labor Day
        if(Month.SEPTEMBER.equals(day.getMonth()) && day.with(firstInMonth(DayOfWeek.MONDAY)).equals(day)) {
            return true;
        }
        return false;
    }

    private boolean isWeekday(LocalDate day) {
        if(DayOfWeek.SATURDAY.equals(DayOfWeek.from(day)) || DayOfWeek.SUNDAY.equals(DayOfWeek.from(day))) {
            return false;
        }
        return true;
    }

}

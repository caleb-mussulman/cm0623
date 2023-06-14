package com.cm0623.service;

import com.cm0623.dao.ToolDao;
import com.cm0623.model.domain.CheckoutForm;
import com.cm0623.model.domain.RentalAgreement;
import com.cm0623.model.dto.RentalCalendar;
import com.cm0623.model.dto.Tool;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Validated
@Service
public class RentalCheckoutService {

    private final ToolDao toolDao;
    private final RentalCalendarService rentalCalendarService;

    @Autowired
    public RentalCheckoutService(ToolDao toolDao, RentalCalendarService rentalCalendarService) {
        this.toolDao = toolDao;
        this.rentalCalendarService = rentalCalendarService;
    }
    public RentalAgreement createRentalAgreement(@Valid CheckoutForm checkoutForm) {
        Tool tool = toolDao.getToolById(checkoutForm.getToolCode());
        RentalCalendar rentalCalendar = rentalCalendarService.constructRentalCalendar(checkoutForm.getCheckoutDate(), checkoutForm.getRentalDayCount());

        Integer chargeableHolidayCount = tool.getIsHolidayCharge() ? rentalCalendar.getHolidayCount() : 0;
        Integer chargeableWeekdayCount = tool.getIsWeekdayCharge() ? rentalCalendar.getWeekdayCount() : 0;
        Integer chargeableWeekendCount = tool.getIsWeekendCharge() ? rentalCalendar.getWeekendCount() : 0;
        Integer chargeableDayCount = chargeableHolidayCount + chargeableWeekdayCount + chargeableWeekendCount;

        BigDecimal preDiscountChargeAmount = tool.getChargeAmount().multiply(BigDecimal.valueOf(chargeableDayCount));
        BigDecimal discountAmount = preDiscountChargeAmount.multiply(BigDecimal.valueOf(checkoutForm.getDiscountPercent())).divide(BigDecimal.valueOf(100L), RoundingMode.HALF_UP);
        BigDecimal finalChargeAmount = preDiscountChargeAmount.subtract(discountAmount);

        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setToolCode(tool.getCode());
        rentalAgreement.setToolType(tool.getToolTypeName());
        rentalAgreement.setToolBrand(tool.getBrand());
        rentalAgreement.setRentalDayCount(rentalCalendar.getRentalDayCount());
        rentalAgreement.setCheckoutDate(checkoutForm.getCheckoutDate());
        rentalAgreement.setDueDate(rentalCalendar.getRentalEndDate());
        rentalAgreement.setDailyRentalChargeAmount(tool.getChargeAmount());
        rentalAgreement.setChargeableDayCount(chargeableDayCount);
        rentalAgreement.setPreDiscountChargeAmount(preDiscountChargeAmount);
        rentalAgreement.setDiscountPercent(checkoutForm.getDiscountPercent());
        rentalAgreement.setDiscountAmount(discountAmount);
        rentalAgreement.setFinalChargeAmount(finalChargeAmount);
        return rentalAgreement;
    }
}

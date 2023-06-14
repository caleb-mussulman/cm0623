package com.cm0623.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class RentalAgreement {

    @JsonProperty("tool_code")
    private String toolCode;

    @JsonProperty("tool_type")
    private String toolType;

    @JsonProperty("tool_brand")
    private String toolBrand;

    @JsonProperty("rental_day_count")
    private Integer rentalDayCount;

    @JsonProperty("checkout_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;

    @JsonProperty("due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @JsonProperty("daily_rental_charge_amount")
    private BigDecimal dailyRentalChargeAmount;

    @JsonProperty("chargeable_day_count")
    private Integer chargeableDayCount;

    @JsonProperty("pre_discount_charge_amount")
    private BigDecimal preDiscountChargeAmount;

    @JsonProperty("discount_percent")
    private Integer discountPercent;

    @JsonProperty("discount_amount")
    private BigDecimal discountAmount;

    @JsonProperty("final_charge_amount")
    private BigDecimal finalChargeAmount;

    @Override
    public String toString() {
        return "RentalAgreement:" +
               "\n  Tool code: " + toolCode +
               "\n  Tool type: " + toolType +
               "\n  Tool brand: " + toolBrand +
               "\n  Rental days: " + rentalDayCount +
               "\n  Check out date: " + checkoutDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")) +
               "\n  Due date: " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yy")) +
               "\n  Daily rental charge: " + String.format("$%,.2f", dailyRentalChargeAmount) +
               "\n  Charge days: " + chargeableDayCount +
               "\n  Pre-discount charge: " + String.format("$%,.2f", preDiscountChargeAmount) +
               "\n  Discount percent: " + String.format("%d%%", discountPercent) +
               "\n  Discount amount: " + String.format("$%,.2f", discountAmount) +
               "\n  Final charge: " + String.format("$%,.2f", finalChargeAmount);
    }
}

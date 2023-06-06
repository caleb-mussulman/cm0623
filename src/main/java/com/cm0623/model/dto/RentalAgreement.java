package com.cm0623.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;

    @JsonProperty("due_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    // TODO different type for currency
    @JsonProperty("daily_rental_charge_amount")
    private Integer dailyRentalChargeAmount;

    @JsonProperty("chargeable_day_count")
    private Integer chargeableDayCount;

    // TODO different type for currency
    @JsonProperty("pre_discount_charge_amount")
    private Integer preDiscountChargeAmount;

    @JsonProperty("discount_percent")
    private Integer discountPercent;

    // TODO different type for currency
    @JsonProperty("discount_amount")
    private Integer discountAmount;

    // TODO different type for currency
    @JsonProperty("final_charge_amount")
    private Integer finalChargeAmount;
}

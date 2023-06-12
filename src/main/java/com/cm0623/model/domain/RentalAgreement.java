package com.cm0623.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
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
}

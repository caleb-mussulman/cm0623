package com.cm0623.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonPropertyOrder({"tool_code", "rental_day_count", "discount_percent", "checkout_date"})
public class CheckoutForm {

    @JsonProperty("tool_code")
    private String toolCode;

    @JsonProperty("rental_day_count")
    private Integer rentalDayCount;

    @JsonProperty("discount_percent")
    private Integer discountPercent;

    @JsonProperty("checkout_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;
}

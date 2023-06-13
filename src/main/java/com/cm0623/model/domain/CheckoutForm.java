package com.cm0623.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Validated
@JsonPropertyOrder({"tool_code", "rental_day_count", "discount_percent", "checkout_date"})
public class CheckoutForm {

    @JsonProperty("tool_code")
    @NotEmpty(message = "Please provide a non-empty value for tool_code")
    private String toolCode;

    @JsonProperty("rental_day_count")
    @Min(value = 1, message = "Please provide an integer value greater than or equal to 1 for rental_day_count")
    private Integer rentalDayCount;

    @JsonProperty("discount_percent")
    @Min(value = 0,   message = "Please provide an integer value in the inclusive range of [0,100] for discount_percent")
    @Max(value = 100, message = "Please provide an integer value in the inclusive range of [0,100] for discount_percent")
    private Integer discountPercent;

    @JsonProperty("checkout_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;
}

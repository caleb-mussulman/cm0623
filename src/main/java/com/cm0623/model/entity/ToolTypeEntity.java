package com.cm0623.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(schema = "depot", name = "tool_type")
public class ToolTypeEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "tool_name")
    private String toolName;

    @Column(name = "charge_amount")
    private BigDecimal chargeAmount;

    @Column(name = "is_weekday_charge")
    private Boolean isWeekdayCharge;

    @Column(name = "is_weekend_charge")
    private Boolean isWeekendCharge;

    @Column(name = "is_holiday_charge")
    private Boolean isHolidayCharge;

}

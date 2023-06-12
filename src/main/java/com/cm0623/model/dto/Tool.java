package com.cm0623.model.dto;

import com.cm0623.model.entity.ToolEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Tool {

    private String code;
    private String brand;
    private String toolTypeName;
    private BigDecimal chargeAmount;
    private Boolean isWeekdayCharge;
    private Boolean isWeekendCharge;
    private Boolean isHolidayCharge;

    public Tool(ToolEntity entity) {
        this.setCode(entity.getCode());
        this.setBrand(entity.getBrand());
        this.setToolTypeName(entity.getToolTypeEntity().getToolName());
        this.setChargeAmount(entity.getToolTypeEntity().getChargeAmount());
        this.setIsWeekdayCharge(entity.getToolTypeEntity().getIsWeekdayCharge());
        this.setIsWeekendCharge(entity.getToolTypeEntity().getIsWeekendCharge());
        this.setIsHolidayCharge(entity.getToolTypeEntity().getIsHolidayCharge());
    }
}

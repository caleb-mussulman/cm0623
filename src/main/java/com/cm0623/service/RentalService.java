package com.cm0623.service;

import com.cm0623.dao.ToolDao;
import com.cm0623.model.dto.CheckoutForm;
import com.cm0623.model.dto.RentalAgreement;
import com.cm0623.model.dto.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final ToolDao toolDao;

    @Autowired
    public RentalService(ToolDao toolDao) {
        this.toolDao = toolDao;
    }
    public RentalAgreement createRentalAgreement(CheckoutForm checkoutForm) {
        Tool tool = toolDao.getToolById(checkoutForm.getToolCode());

        // TODO add logic

        RentalAgreement rentalAgreement = new RentalAgreement();
        return rentalAgreement;
    }
}

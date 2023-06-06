package com.cm0623.controller;

import com.cm0623.model.dto.CheckoutForm;
import com.cm0623.model.dto.RentalAgreement;
import com.cm0623.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping(value = "/checkout", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentalAgreement createRentalAgreement(@Validated @RequestBody CheckoutForm checkoutForm) {
        return rentalService.createRentalAgreement(checkoutForm);
    }
}

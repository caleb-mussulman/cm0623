package com.cm0623.controller;

import com.cm0623.model.domain.CheckoutForm;
import com.cm0623.model.domain.RentalAgreement;
import com.cm0623.service.RentalCheckoutService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@Validated
@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalCheckoutService rentalCheckoutService;

    @Autowired
    public RentalController(RentalCheckoutService rentalCheckoutService) {
        this.rentalCheckoutService = rentalCheckoutService;
    }

    @PostMapping(value = "/checkout", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RentalAgreement createRentalAgreement(@Valid @RequestBody CheckoutForm checkoutForm) {
        RentalAgreement rentalAgreement = rentalCheckoutService.createRentalAgreement(checkoutForm);
        log.info(rentalAgreement.toString());
        return rentalAgreement;
    }
}

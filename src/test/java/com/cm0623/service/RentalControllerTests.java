package com.cm0623.service;

import com.cm0623.controller.RentalController;
import com.cm0623.model.domain.CheckoutForm;
import com.cm0623.model.domain.RentalAgreement;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Import(ValidationAutoConfiguration.class)
public class RentalControllerTests {
    
    @Autowired
    private RentalController rentalController;

    @Test
    public void createRentalAgreement_test1() {
        CheckoutForm checkoutForm = new CheckoutForm(
                "JAKR",
                5,
                101,
                LocalDate.of(2015, 9, 3));
        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            rentalController.createRentalAgreement(checkoutForm);
        });
        String expectedMessage = "Please provide an integer value in the inclusive range of [0,100] for discount_percent";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void createRentalAgreement_test2() {
        CheckoutForm checkoutForm = new CheckoutForm(
                "LADW",
                3,
                10,
                LocalDate.of(2020, 7, 2));
        RentalAgreement rentalAgreement = rentalController.createRentalAgreement(checkoutForm);
        assertNotNull(rentalAgreement);
        assertEquals("LADW", rentalAgreement.getToolCode());
        assertEquals("Ladder", rentalAgreement.getToolType());
        assertEquals("Werner", rentalAgreement.getToolBrand());
        assertEquals(3, rentalAgreement.getRentalDayCount());
        assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2020, 7, 5), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(1.99), rentalAgreement.getDailyRentalChargeAmount());
        assertEquals(2, rentalAgreement.getChargeableDayCount());
        assertEquals(BigDecimal.valueOf(3.98), rentalAgreement.getPreDiscountChargeAmount());
        assertEquals(10, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.40).setScale(2), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.58), rentalAgreement.getFinalChargeAmount());
    }

    @Test
    public void createRentalAgreement_test3() {
        CheckoutForm checkoutForm = new CheckoutForm(
                "CHNS",
                5,
                25,
                LocalDate.of(2015, 7, 2));
        RentalAgreement rentalAgreement = rentalController.createRentalAgreement(checkoutForm);
        assertNotNull(rentalAgreement);
        assertEquals("CHNS", rentalAgreement.getToolCode());
        assertEquals("Chainsaw", rentalAgreement.getToolType());
        assertEquals("Stihl", rentalAgreement.getToolBrand());
        assertEquals(5, rentalAgreement.getRentalDayCount());
        assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2015, 7, 7), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(1.49), rentalAgreement.getDailyRentalChargeAmount());
        assertEquals(3, rentalAgreement.getChargeableDayCount());
        assertEquals(BigDecimal.valueOf(4.47), rentalAgreement.getPreDiscountChargeAmount());
        assertEquals(25, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(1.12), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(3.35), rentalAgreement.getFinalChargeAmount());
    }

    @Test
    public void createRentalAgreement_test4() {
        CheckoutForm checkoutForm = new CheckoutForm(
                "JAKD",
                6,
                0,
                LocalDate.of(2015, 9, 3));
        RentalAgreement rentalAgreement = rentalController.createRentalAgreement(checkoutForm);
        assertNotNull(rentalAgreement);
        assertEquals("JAKD", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("DeWalt", rentalAgreement.getToolBrand());
        assertEquals(6, rentalAgreement.getRentalDayCount());
        assertEquals(LocalDate.of(2015, 9, 3), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2015, 9, 9), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalChargeAmount());
        assertEquals(3, rentalAgreement.getChargeableDayCount());
        assertEquals(BigDecimal.valueOf(8.97), rentalAgreement.getPreDiscountChargeAmount());
        assertEquals(0, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(8.97), rentalAgreement.getFinalChargeAmount());
    }

    @Test
    public void createRentalAgreement_test5() {
        CheckoutForm checkoutForm = new CheckoutForm(
                "JAKR",
                9,
                0,
                LocalDate.of(2015, 7, 2));
        RentalAgreement rentalAgreement = rentalController.createRentalAgreement(checkoutForm);
        assertNotNull(rentalAgreement);
        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getToolBrand());
        assertEquals(9, rentalAgreement.getRentalDayCount());
        assertEquals(LocalDate.of(2015, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2015, 7, 11), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalChargeAmount());
        assertEquals(5, rentalAgreement.getChargeableDayCount());
        assertEquals(BigDecimal.valueOf(14.95), rentalAgreement.getPreDiscountChargeAmount());
        assertEquals(0, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(0.00).setScale(2), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(14.95), rentalAgreement.getFinalChargeAmount());
    }

    @Test
    public void createRentalAgreement_test6() {
        CheckoutForm checkoutForm = new CheckoutForm(
                "JAKR",
                4,
                50,
                LocalDate.of(2020, 7, 2));
        RentalAgreement rentalAgreement = rentalController.createRentalAgreement(checkoutForm);
        assertNotNull(rentalAgreement);
        assertEquals("JAKR", rentalAgreement.getToolCode());
        assertEquals("Jackhammer", rentalAgreement.getToolType());
        assertEquals("Ridgid", rentalAgreement.getToolBrand());
        assertEquals(4, rentalAgreement.getRentalDayCount());
        assertEquals(LocalDate.of(2020, 7, 2), rentalAgreement.getCheckoutDate());
        assertEquals(LocalDate.of(2020, 7, 6), rentalAgreement.getDueDate());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getDailyRentalChargeAmount());
        assertEquals(1, rentalAgreement.getChargeableDayCount());
        assertEquals(BigDecimal.valueOf(2.99), rentalAgreement.getPreDiscountChargeAmount());
        assertEquals(50, rentalAgreement.getDiscountPercent());
        assertEquals(BigDecimal.valueOf(1.50).setScale(2), rentalAgreement.getDiscountAmount());
        assertEquals(BigDecimal.valueOf(1.49), rentalAgreement.getFinalChargeAmount());
    }
}

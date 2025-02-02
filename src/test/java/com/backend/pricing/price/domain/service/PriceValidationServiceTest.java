package com.backend.pricing.price.domain.service;

import com.backend.pricing.common.exception.NotFoundException;
import com.backend.pricing.price.domain.entities.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PriceValidationServiceTest {
    @InjectMocks
    private PriceValidationService validationService;

    @Test
    void validatePriceTest() {
        Price price = Price.builder()
                .price(new BigDecimal(55))
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(5))
                .build();
        assertDoesNotThrow(() -> validationService.validatePrice(price));
    }

    @Test
    void validatePriceTestWithPriceNull() {
        Price price = Price.builder()
                .price(null)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(5))
                .build();
        assertThrows(NotFoundException.class, () -> validationService.validatePrice(price));
    }

    @Test
    void validatePriceTestWithErrorDates() {
        Price price = Price.builder()
                .price(new BigDecimal(55))
                .startDate(LocalDateTime.now().plusDays(5))
                .endDate(LocalDateTime.now())
                .build();
        assertThrows(NotFoundException.class, () -> validationService.validatePrice(price));
    }

}
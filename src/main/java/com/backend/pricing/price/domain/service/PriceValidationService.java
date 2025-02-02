package com.backend.pricing.price.domain.service;

import com.backend.pricing.common.exception.NotFoundException;
import com.backend.pricing.price.domain.entities.Price;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PriceValidationService {
    public void validatePrice(Price price) {
        if (price.getPrice() == null || price.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new NotFoundException("The price must be greater than 0");

        }
        if (price.getStartDate().isAfter(price.getEndDate())) {
            throw new NotFoundException("The start date cannot be later than the end date");
        }
    }
}

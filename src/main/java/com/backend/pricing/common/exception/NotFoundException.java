package com.backend.pricing.common.exception;

import java.io.Serial;

public class NotFoundException extends PricingException {
    @Serial
    private static final long serialVersionUID = -7769326816151490381L;

    public NotFoundException(String message) {
        super(message);
    }
}

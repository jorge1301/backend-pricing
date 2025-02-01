package com.backend.pricing.common.exception;

import java.io.Serial;

public class PricingException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = 6643967555795279842L;

    public PricingException(String message) {
        super(message);
    }
}

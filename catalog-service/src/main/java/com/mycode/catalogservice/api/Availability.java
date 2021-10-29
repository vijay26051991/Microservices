package com.mycode.catalogservice.api;

public enum Availability {
    AVAILABLE(1),
    NOT_AVAILABLE(0);

    private final Integer availCode;

    Availability(final Integer availCode) {
        this.availCode = availCode;
    }

    public Integer getAvailCode() {
        return availCode;
    }
}

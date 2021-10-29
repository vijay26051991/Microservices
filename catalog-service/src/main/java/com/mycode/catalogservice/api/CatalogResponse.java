package com.mycode.catalogservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class CatalogResponse extends ResponseEntity {

    public CatalogResponse(HttpStatus status) {
        super(status);
    }

    public CatalogResponse(Object body, HttpStatus status) {
        super(body, status);
    }

    public CatalogResponse(MultiValueMap headers, HttpStatus status) {
        super(headers, status);
    }

    public CatalogResponse(Object body, MultiValueMap headers, HttpStatus status) {
        super(body, headers, status);
    }

    public CatalogResponse(Object body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }
}

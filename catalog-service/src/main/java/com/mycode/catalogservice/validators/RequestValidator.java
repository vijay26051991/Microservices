package com.mycode.catalogservice.validators;

public interface RequestValidator<T> {
    void validate(T t) throws IllegalAccessException;
}

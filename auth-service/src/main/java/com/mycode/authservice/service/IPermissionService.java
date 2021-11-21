package com.mycode.authservice.service;

public interface IPermissionService<T> {
    Long createPermission(final T t);

    T updatePermission(final T t);

    void deletePermission(final String id);
}

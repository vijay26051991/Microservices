package com.mycode.authservice.service;

import com.mycode.authservice.rest.api.Role;

import java.util.Collection;

public interface IRoleService<T> {
    Long createRole(final T role);

    T updateRole(final T role);

    Role linkRoleAndPermission(final String permissionId, final String roleId);

    void deleteRole(final String roleId);

    T byId(final String roleId);

    Collection<T> byAll();

    void linkUserAndPermission(final String userId, final String roleId);
}

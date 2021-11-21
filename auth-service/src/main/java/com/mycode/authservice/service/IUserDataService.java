package com.mycode.authservice.service;

import com.mycode.authservice.rest.api.User;

import java.util.Collection;

public interface IUserDataService {

    User getUserById(final Long userId);

    User getUserByEmail(final String email);

    User getUserByPhone(final String phone);

    Collection<User> getAllUsers();

    void deleteUser(final String userId);

    Long createUser(final User user);

    User updateUser(final User user);
}

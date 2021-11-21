package com.mycode.authservice.service;

import com.mycode.authservice.repositories.RoleDataRepository;
import com.mycode.authservice.repositories.UserDataRepository;
import com.mycode.authservice.rest.api.User;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDataService implements IUserDataService {

    private final UserDataRepository userDataRepository;
    private final RoleDataRepository roleDataRepository;

    public UserDataService(final UserDataRepository userDataRepository, final RoleDataRepository roleDataRepository) {
        this.roleDataRepository = roleDataRepository;
        this.userDataRepository = userDataRepository;
    }

    @Transactional()
    @Override
    public User getUserById(Long userId) {
        User user = new User();
        BeanUtils.copyProperties(userDataRepository.findById(userId), user);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = new User();
        BeanUtils.copyProperties(userDataRepository.findByEmail(email), user);
        return user;
    }

    @Override
    public User getUserByPhone(String phone) {
        User user = new User();
        BeanUtils.copyProperties(userDataRepository.findByEmail(phone), user);
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        List<User> users = userDataRepository.findAll()
                .stream()
                .map(user -> {
                    return new User(user.getId(), user.getFirstName(), user.getLastName(), user.getEmailAddress(), user.getPhonaNumber(), user.getCompanyName(), null, user.getRoles().stream().map(role -> String.valueOf(role.getId())).collect(Collectors.toList()));
                }).collect(Collectors.toList());
        return users;
    }

    @Override
    public void deleteUser(final String userId) {
        userDataRepository.deleteById(Long.valueOf(userId));
    }

    @Transactional
    @Override
    public Long createUser(User user) {
        com.mycode.authservice.data.User userEntity = new com.mycode.authservice.data.User();
        userEntity.setCompanyName(user.getCompanyName());
        userEntity.setEmailAddress(user.getEmailAddress());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhonaNumber(user.getPhonaNumber());
        userEntity.setRoles(user.getRoles().stream().map(s -> roleDataRepository.findById(Long.valueOf(s)).get()).collect(Collectors.toList()));
        com.mycode.authservice.data.User save = userDataRepository.save(userEntity);
        return save.getId();
    }

    @Transactional
    @Modifying(flushAutomatically = true)
    @Override
    public User updateUser(User user) {
        com.mycode.authservice.data.User userEntity = new com.mycode.authservice.data.User();
        User updated = new User();
        BeanUtils.copyProperties(user, userEntity);
        com.mycode.authservice.data.User persisted = userDataRepository.save(userEntity);
        BeanUtils.copyProperties(persisted, updated);
        return updated;
    }
}

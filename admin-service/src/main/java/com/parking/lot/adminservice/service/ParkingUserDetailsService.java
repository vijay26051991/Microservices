package com.parking.lot.adminservice.service;

import com.parking.lot.adminservice.jpa.ParkingUser;
import com.parking.lot.adminservice.jpa.ParkingUserDetails;

import com.parking.lot.adminservice.repositories.ParkingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingUserDetailsService implements UserDetailsService {

    @Autowired
    ParkingUserRepository adminUserRepository;

    @Override
    public ParkingUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        final Optional<ParkingUser> adminUserByUserName = adminUserRepository.findAdminUserByUserName(userName);

        adminUserByUserName.orElseThrow(() -> new UsernameNotFoundException(userName + " not found. Please create a new user"));

        ParkingUserDetails adminUserDetails = new ParkingUserDetails(adminUserByUserName.get());

        return adminUserDetails;
    }
}

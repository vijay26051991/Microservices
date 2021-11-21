package com.parking.lot.adminservice.jpa;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class ParkingUserDetails implements UserDetails {
    private String userName;
    private String password;
    private boolean active;
    private Collection<GrantedAuthority> grantedAuthorities;

    public ParkingUserDetails() {
    }

    public ParkingUserDetails(ParkingUser parkingUser) {
        this.userName = parkingUser.getUserName();
        this.password = parkingUser.getPassword();
        this.active = parkingUser.isActive();

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        this.setGrantedAuthorities(grantedAuthorities);
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Collection<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }
}

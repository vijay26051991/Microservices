package com.mycode.authservice.rest.api;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Long userId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String phonaNumber;

    private String companyName;

    private String password;

    private Collection<String> roles;

    public User(){}

    public User(@JsonProperty("user_id") Long userId,
                @JsonProperty("first_name") String firstName,
                @JsonProperty("last_name") String lastName,
                @JsonProperty("email") String emailAddress,
                @JsonProperty("phone") String phonaNumber,
                @JsonProperty("company") String companyName,
                @JsonProperty("password") String password,
                @JsonProperty("roles") Collection<String> roles) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phonaNumber = phonaNumber;
        this.companyName = companyName;
        this.password = password;
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhonaNumber() {
        return phonaNumber;
    }

    public void setPhonaNumber(String phonaNumber) {
        this.phonaNumber = phonaNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}


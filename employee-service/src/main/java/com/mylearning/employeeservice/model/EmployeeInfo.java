package com.mylearning.employeeservice.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
public class EmployeeInfo {

    private Long empId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String designation;
    private String email;
    private String phone;
}

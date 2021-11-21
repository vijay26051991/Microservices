package com.mylearning.employeeservice.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Employee")
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_SEQ")
    @SequenceGenerator(name = "EMPLOYEE_ID_SEQ", sequenceName = "EMPLOYEE_ID_SEQ", schema = "public")
    private Long employeeId;


    private String firstName;


    private String lastName;

    private LocalDate dob;

    private String email;

    private String phone;

    private String designation;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String lastName, LocalDate dob, String email, String phone, String designation) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

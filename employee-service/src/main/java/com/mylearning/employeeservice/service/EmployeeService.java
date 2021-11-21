package com.mylearning.employeeservice.service;

import com.mylearning.employeeservice.entity.Employee;
import com.mylearning.employeeservice.model.EmployeeInfo;
import com.mylearning.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Long createEmployee(final EmployeeInfo employeeInfo) {
        Employee employee = new Employee();
        employee.setEmail(employeeInfo.getEmail());
        employee.setPhone(employeeInfo.getPhone());
        employee.setFirstName(employeeInfo.getFirstName());
        employee.setLastName(employeeInfo.getLastName());
        employee.setDesignation(employeeInfo.getDesignation());
        employee.setDob(employeeInfo.getDob());
        Employee save = employeeRepository.save(employee);
        return save.getEmployeeId();
    }

    public EmployeeInfo getEmployeeById(long id) {
        Employee existingEmployee = employeeRepository.getOne(id);
        EmployeeInfo employeeInfo = EmployeeInfo
                .builder()
                .empId(existingEmployee.getEmployeeId())
                .dob(existingEmployee.getDob())
                .firstName(existingEmployee.getFirstName())
                .lastName(existingEmployee.getLastName())
                .email(existingEmployee.getEmail())
                .phone(existingEmployee.getPhone())
                .designation(existingEmployee.getDesignation())
                .build();

        return employeeInfo;
    }
}

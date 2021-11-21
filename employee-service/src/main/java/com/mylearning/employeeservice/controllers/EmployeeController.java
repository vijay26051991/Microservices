package com.mylearning.employeeservice.controllers;

import com.mylearning.employeeservice.model.EmployeeInfo;
import com.mylearning.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/onboardEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long onboardEmployee(@RequestBody EmployeeInfo employeeInfo) {
        log.info("Received controller " + employeeInfo.toString());
        Long employeeId = employeeService.createEmployee(employeeInfo);
        return employeeId;
    }

    @GetMapping(value = "/byId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmployeeInfo getEmployeeById(@RequestParam("id") long id){
        return employeeService.getEmployeeById(id);
    }
}

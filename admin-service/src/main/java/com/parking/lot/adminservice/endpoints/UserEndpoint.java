package com.parking.lot.adminservice.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndpoint {

    @GetMapping("/admin")
    public String login() {
        return "Success";
    }


    @GetMapping("/user")
    public String user() {
        return "Success";
    }

    @GetMapping("/all")
    public String all() {
        return "Success";
    }
}

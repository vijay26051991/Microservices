package com.mycode.authservice.controller;

import com.mycode.authservice.rest.api.User;
import com.mycode.authservice.service.UserDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserEndpointController {

    private final UserDataService userDataService;

    public UserEndpointController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody final User user) {
        return ResponseEntity.status(HttpStatus.OK).body(String.valueOf(userDataService.createUser(user)));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody final User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userDataService.updateUser(user));
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<Void> updateUser(@PathVariable("userid") String userid) {
        userDataService.deleteUser(userid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("userid") String userid) {
        return ResponseEntity.status(HttpStatus.OK).body(userDataService.getUserById(Long.valueOf(userid)));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> allUsers = userDataService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(allUsers);
    }
}

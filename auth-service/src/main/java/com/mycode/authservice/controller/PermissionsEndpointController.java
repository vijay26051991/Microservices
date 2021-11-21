package com.mycode.authservice.controller;

import com.mycode.authservice.rest.api.Permission;
import com.mycode.authservice.service.PermissionDataService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionsEndpointController {

    private final PermissionDataService permissionDataService;

    public PermissionsEndpointController(PermissionDataService permissionDataService) {
        this.permissionDataService = permissionDataService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPermission(@RequestBody final Permission permission) {
        return ResponseEntity.ok(String.valueOf(permissionDataService.createPermission(permission)));
    }

    @PutMapping
    public ResponseEntity<Permission> updatePermission(@RequestBody final Permission permission) {
        return ResponseEntity.ok(permissionDataService.updatePermission(permission));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePermission(final String permissionId) {
        permissionDataService.deletePermission(permissionId);
        return ResponseEntity.status(200).build();
    }
}

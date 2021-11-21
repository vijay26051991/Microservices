package com.mycode.authservice.controller;

import com.mycode.authservice.rest.api.Role;
import com.mycode.authservice.service.IRoleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/roles")
public class RoleEndpointController {

    IRoleService roleService;

    public RoleEndpointController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createRole(@RequestBody final Role role) {
        return ResponseEntity.ok(String.valueOf(roleService.createRole(role)));
    }

    @DeleteMapping("/{roldId}")
    public ResponseEntity<Void> deleteRole(@RequestBody final String roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.status(200).build();
    }

    @PutMapping
    public ResponseEntity<Role> updateRole(@RequestBody final Role role) {
        final Role updatedRole = (Role) roleService.updateRole(role);
        return ResponseEntity.status(200).body(updatedRole);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<Role> byRoleId(@PathVariable("roleId") final String roleId) {
        return ResponseEntity.ok().body((Role) roleService.byId(roleId));
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Role>> all() {
        return ResponseEntity.status(200).body(roleService.byAll());
    }

    @GetMapping("/{roleId}/{permissionId}")
    public ResponseEntity<Role> linkRoleAndPermission(@PathVariable("roleId") final String roleId,
                                         @PathVariable("permissionId") final String permissionId) {
        final Role role = roleService.linkRoleAndPermission(permissionId, roleId);

        return ResponseEntity.status(200).body(role);
    }

}

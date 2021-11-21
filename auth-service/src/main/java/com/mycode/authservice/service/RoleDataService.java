package com.mycode.authservice.service;

import com.mycode.authservice.data.Permission;
import com.mycode.authservice.data.User;
import com.mycode.authservice.exceptions.AuthServiceException;
import com.mycode.authservice.repositories.PermissionDataRepository;
import com.mycode.authservice.repositories.RoleDataRepository;
import com.mycode.authservice.repositories.UserDataRepository;
import com.mycode.authservice.rest.api.Role;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleDataService implements IRoleService<Role> {

    private final UserDataRepository userDataRepository;

    private final RoleDataRepository roleDataRepository;

    private final PermissionDataRepository permissionDataRepository;

    public RoleDataService(final UserDataRepository userDataRepository,
                           final RoleDataRepository roleDataRepository,
                           final PermissionDataRepository permissionDataRepository) {
        this.userDataRepository = userDataRepository;
        this.roleDataRepository = roleDataRepository;
        this.permissionDataRepository = permissionDataRepository;
    }

    @Override
    public Long createRole(final Role role) {

        final com.mycode.authservice.data.Role roleEntity = new com.mycode.authservice.data.Role();
        roleEntity.setRoleDescription(role.getRoleDescription());
        roleEntity.setRoleName(role.getRoleName());
        roleEntity.setPermissions(null);
        List<User> userEntitites = role.getUsers().stream()
                .map(s -> userDataRepository.findById(Long.valueOf(s)))
                .map(userEntity -> userEntity.get())
                .collect(Collectors.toList());

        List<Permission> permissions = role.getPermissions().stream()
                .map(s -> permissionDataRepository.findById(Long.valueOf(s)))
                .map(userEntity -> userEntity.get())
                .collect(Collectors.toList());

        roleEntity.setUsers(userEntitites);
        roleEntity.setPermissions(permissions);
        com.mycode.authservice.data.Role newRole = roleDataRepository.save(roleEntity);

        return Long.valueOf(newRole.getId());
    }

    @Override
    public Role updateRole(Role role) {

        //check role exists.
        final Optional<com.mycode.authservice.data.Role> roleById = roleDataRepository.findById(Long.valueOf(role.getRoleId()));

        if (!(roleById.isPresent())) {
            throw new AuthServiceException(HttpStatus.BAD_REQUEST, "Unable to find the role : " + role.getRoleId());
        }

        //construct entity object.
        final com.mycode.authservice.data.Role roleEntity = new com.mycode.authservice.data.Role();
        roleEntity.setId(Long.valueOf(role.getRoleId()));
        roleEntity.setRoleDescription(role.getRoleDescription());
        roleEntity.setRoleName(role.getRoleName());

        final com.mycode.authservice.data.Role updatedEntity = roleDataRepository.save(roleEntity);//I should use save method for update.

        final Role response
                = new Role(String.valueOf(updatedEntity.getId()),
                updatedEntity.getRoleName(),
                updatedEntity.getRoleDescription(),
                updatedEntity.getUsers()
                        .stream().map(userEntity -> String.valueOf(userEntity.getId()))
                        .collect(Collectors.toList()),
                updatedEntity.getPermissions()
                        .stream().map(permissionEntity -> String.valueOf(permissionEntity.getId()))
                        .collect(Collectors.toList()));


        return response;
    }

    @Transactional(readOnly = true)
    @Override
    public Role linkRoleAndPermission(String permissionId, String roleId) {
        Optional<com.mycode.authservice.data.Permission> permissionEntity = permissionDataRepository.findById(Long.valueOf(permissionId));

        Optional<com.mycode.authservice.data.Role> roleEntity = roleDataRepository.findById(Long.valueOf(roleId));

        if (!(permissionEntity.isPresent()) || !(roleEntity.isPresent())) {
            throw new AuthServiceException(HttpStatus.BAD_REQUEST, "Check the roleId and permissionId exists!");
        }

        roleEntity.get().getPermissions().add(permissionEntity.get());

        final com.mycode.authservice.data.Role updatedRoleEntity = roleDataRepository.save(roleEntity.get());

        final Role role = new Role(String.valueOf(updatedRoleEntity.getId()),
                             updatedRoleEntity.getRoleName(),
                             updatedRoleEntity.getRoleDescription(),
                             null,
                             updatedRoleEntity.getPermissions()
                                                .stream()
                                                .map(pe -> String.valueOf(pe.getId()))
                                                .collect(Collectors.toList()));

        return role;
    }

    @Override
    public void deleteRole(String roleId) {
        Optional<com.mycode.authservice.data.Role> roleById = roleDataRepository.findById(Long.valueOf(roleId));

        if (!(roleById.isPresent())) {
            throw new AuthServiceException(HttpStatus.BAD_REQUEST, "Unable to find the role : " + roleId);
        }

        userDataRepository.deleteById(Long.valueOf(roleId));
    }

    @Override
    public Role byId(final String roleId) {
        Optional<com.mycode.authservice.data.Role> optionalRoleEntity = roleDataRepository.findById(Long.valueOf(roleId));

        com.mycode.authservice.data.Role roleEntity = optionalRoleEntity.orElseThrow(() -> new AuthServiceException(HttpStatus.BAD_REQUEST, "No role exists for the roleId : " + roleId));

        return new Role(String.valueOf(roleEntity.getId()),
                             roleEntity.getRoleName(),
                             roleEntity.getRoleDescription(),
                             roleEntity.getUsers().stream().map(userEntity -> String.valueOf(userEntity.getId())).collect(Collectors.toList()),
                             roleEntity.getPermissions().stream().map(permissionEntity -> String.valueOf(permissionEntity.getId())).collect(Collectors.toList()));
    }

    @Override
    public Collection<Role> byAll() {

        return roleDataRepository.findAll().stream().map(
                roleEntity -> new Role(String.valueOf(roleEntity.getId()),
                        roleEntity.getRoleName(),
                        roleEntity.getRoleDescription(),
                        roleEntity.getUsers()
                                .stream().map(com.mycode.authservice.data.User::getId)
                                .map(String::valueOf)
                                .collect(Collectors.toList()),
                        roleEntity.getPermissions()
                                .stream()
                                .map(com.mycode.authservice.data.Permission::getId)
                                .map(String::valueOf)
                                .collect(Collectors.toList()))
        ).collect(Collectors.toList());

    }

    @Override
    public void linkUserAndPermission(String userId, String roleId) {
        Optional<com.mycode.authservice.data.User> userEntity = userDataRepository.findById(Long.valueOf(userId));

        Optional<com.mycode.authservice.data.Role> roleEntity = roleDataRepository.findById(Long.valueOf(roleId));

        if (!(userEntity.isPresent()) || !(roleEntity.isPresent())) {
            throw new AuthServiceException(HttpStatus.BAD_REQUEST, "Check the roleId and userId exists!");
        }

        roleEntity.get().getUsers().add(userEntity.get());
    }
}

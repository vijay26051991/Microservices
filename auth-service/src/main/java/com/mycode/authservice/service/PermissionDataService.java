package com.mycode.authservice.service;

import com.mycode.authservice.exceptions.AuthServiceException;
import com.mycode.authservice.repositories.PermissionDataRepository;
import com.mycode.authservice.repositories.RoleDataRepository;
import com.mycode.authservice.rest.api.Permission;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissionDataService implements IPermissionService<Permission> {

    RoleDataRepository roleDataRepository;

    PermissionDataRepository permissionDataRepository;

    public PermissionDataService(RoleDataRepository roleDataRepository, PermissionDataRepository permissionDataRepository) {
        this.roleDataRepository = roleDataRepository;
        this.permissionDataRepository = permissionDataRepository;
    }

    @Override
    public Long createPermission(Permission permission) {
        final com.mycode.authservice.data.Permission permissionEntity = new com.mycode.authservice.data.Permission();
        permissionEntity.setPermissionName(permission.getPermissionName());
        permissionEntity.setPermissionDescription(permission.getPermissionDescription());

        final List<Long> ids = permission.getRoles()
                .stream()
                .map(role -> Long.valueOf(role))
                .collect(Collectors.toList());

        final List<com.mycode.authservice.data.Role> roleEntities = roleDataRepository.findAllById(ids);

        permissionEntity.setRoles(roleEntities);
        final com.mycode.authservice.data.Permission persistedEntity = permissionDataRepository.save(permissionEntity);
        return persistedEntity.getId();
    }

    @Override
    public Permission updatePermission(Permission permission) {
        final Optional<com.mycode.authservice.data.Permission> optionalPermissionEntity
                = permissionDataRepository.findById(Long.valueOf(permission.getPermissionId()));

        if (!optionalPermissionEntity.isPresent()) {
            throw new AuthServiceException(HttpStatus.BAD_REQUEST, "Unable to find the permission");
        }
        com.mycode.authservice.data.Permission permissionEntity = new com.mycode.authservice.data.Permission();
        permissionEntity.setPermissionName(permission.getPermissionName());
        permissionEntity.setPermissionDescription(permission.getPermissionDescription());
        permissionEntity.setRoles(optionalPermissionEntity.get().getRoles());
        permissionEntity.setId(optionalPermissionEntity.get().getId());

        final com.mycode.authservice.data.Permission updatePermissionEntity = permissionDataRepository.save(permissionEntity);

        final Permission newPermission
                = new Permission(updatePermissionEntity.getId(),
                                 updatePermissionEntity.getPermissionName(),
                                 updatePermissionEntity.getPermissionDescription(),
                                 updatePermissionEntity.getRoles()
                                            .stream()
                                            .map(roleEntity -> String.valueOf(roleEntity.getId()))
                                            .collect(Collectors.toList()));

        return newPermission;
    }

    @Override
    public void deletePermission(String id) {
        final Optional<com.mycode.authservice.data.Permission> optionalPermissionEntity = permissionDataRepository.findById(Long.valueOf(id));
        permissionDataRepository.delete(optionalPermissionEntity.get());
    }
}

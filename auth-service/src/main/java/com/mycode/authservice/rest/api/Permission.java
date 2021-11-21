package com.mycode.authservice.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission {

    private Long permissionId;

    private String permissionName;

    private String permissionDescription;

    private Collection<String> roles;

    @JsonCreator
    public Permission(@JsonProperty("permission_id") Long permissionId,
                      @JsonProperty("permission_name") String permissionName,
                      @JsonProperty("permission_description") String permissionDescription,
                      @JsonProperty("roles") Collection<String> roles) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionDescription = permissionDescription;
        this.roles = roles;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}

package com.mycode.authservice.rest.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

    private String roleId;

    private String roleName;

    private String roleDescription;

    private Collection<String> users;

    private Collection<String> permissions;

    @JsonCreator
    public Role(@JsonProperty("role_id") String roleId,
                @JsonProperty("role_name") String roleName,
                @JsonProperty("role_description") String roleDescription,
                @JsonProperty("role_users") Collection<String> users,
                @JsonProperty("role_permissions") Collection<String> permissions) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.users = users;
        this.permissions = permissions;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Collection<String> getUsers() {
        return users;
    }

    public void setUsers(Collection<String> users) {
        this.users = users;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<String> permissions) {
        this.permissions = permissions;
    }
}

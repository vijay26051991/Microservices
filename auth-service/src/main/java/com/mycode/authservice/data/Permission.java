package com.mycode.authservice.data;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

        @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_desc")
    private String permissionDescription;

    @ManyToMany(mappedBy = "permissions")
    private Collection<Role> roles;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}

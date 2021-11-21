package com.parking.lot.adminservice.jpa;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "")
    private Collection<ParkingUser> parkingUsers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

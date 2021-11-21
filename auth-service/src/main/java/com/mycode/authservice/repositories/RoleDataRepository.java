package com.mycode.authservice.repositories;

import com.mycode.authservice.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDataRepository extends JpaRepository<Role, Long> {

}

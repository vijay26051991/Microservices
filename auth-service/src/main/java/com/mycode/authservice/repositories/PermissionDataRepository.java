package com.mycode.authservice.repositories;

import com.mycode.authservice.data.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionDataRepository extends JpaRepository<Permission, Long> {
}

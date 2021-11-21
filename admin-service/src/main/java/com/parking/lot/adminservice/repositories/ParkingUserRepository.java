package com.parking.lot.adminservice.repositories;

import com.parking.lot.adminservice.jpa.ParkingUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingUserRepository extends CrudRepository<ParkingUser, Long> {

    Optional<ParkingUser> findAdminUserByUserName(final String username);
}

package com.mycode.authservice.repositories;


import com.mycode.authservice.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<User, Long> {

    @Query(value = "select ue from UserEntity ue where ue.emailAddress=?1", nativeQuery = true)
    User findByEmail(final String email);

    @Query(value = "select ue from UserEntity ue where ue.phonaNumber=?1", nativeQuery = true)
    User findByPhone(final String phone);
}

package com.endpointupdateuser.UserRepository;

import com.endpointupdateuser.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    public UserEntity findByEmail(String email);
}

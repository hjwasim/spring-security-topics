package com.hjwasim.springsecurity.repository;

import com.hjwasim.springsecurity.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("""
            select u from AppUser u where u.username = :username
            """)
    Optional<AppUser> findUserByUsername(String username);
}

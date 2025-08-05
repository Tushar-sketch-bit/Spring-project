package com.tusharcodes.first.repository;

import com.tusharcodes.first.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom method to find user by email (used during login)
    Optional<User> findByEmail(String email);
}

package com.aydemir.notedapi.repository;

import com.aydemir.notedapi.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User getByEmail(String email);
}

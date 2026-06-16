package com.pranav.exam.onlineexamsystem.repository;

import com.pranav.exam.onlineexamsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
package com.pranav.exam.onlineexamsystem.repository;

import com.pranav.exam.onlineexamsystem.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Long> {
}


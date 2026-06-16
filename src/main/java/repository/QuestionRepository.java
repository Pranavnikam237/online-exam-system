package com.pranav.exam.onlineexamsystem.repository;

import com.pranav.exam.onlineexamsystem.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
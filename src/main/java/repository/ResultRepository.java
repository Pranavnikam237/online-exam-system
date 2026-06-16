package com.pranav.exam.onlineexamsystem.repository;

import com.pranav.exam.onlineexamsystem.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByStudentEmail(String studentEmail);

    @Query(
            value = "SELECT * FROM results ORDER BY score DESC",
            nativeQuery = true
    )
    List<Result> findLeaderboard();
}
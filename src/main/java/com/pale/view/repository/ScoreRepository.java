package com.pale.view.repository;

import com.pale.view.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {
    List<Score> findByStudentId(Long studentId);

    Score findByStudentIdAndSubjectAndTestTime(Long studentId, String subject,String testTime);

    List<Score> findByStudentIdAndTestTime(Long studentId, String testTime);

    List<Score> findByClazzIdAndTestTime(Long classId,String testTime);

}


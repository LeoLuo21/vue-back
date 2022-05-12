package com.pale.view.repository;

import com.pale.view.model.SumScore;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface SumScoreRepository extends Repository<SumScore,Long> {
    SumScore save(SumScore score);
    SumScore findByStudentIdAndTestTime(Long studentId, String testTime);
    List<SumScore> findByClassIdAndTestTime(Long classId,String testTime);
}

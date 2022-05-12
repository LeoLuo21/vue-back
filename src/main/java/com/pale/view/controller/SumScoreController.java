package com.pale.view.controller;

import com.pale.view.model.SumScore;
import com.pale.view.repository.SumScoreRepository;
import com.pale.view.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumScoreController {
    private final SumScoreRepository sumScoreRepository;

    public SumScoreController(SumScoreRepository sumScoreRepository) {
        this.sumScoreRepository = sumScoreRepository;
    }

    @GetMapping("/sumScore/studentId/testTime")
    public R<SumScore> findSumScoreByStudentIdAndTestTime(Long studentId, String testTime) {
        SumScore score = sumScoreRepository.findByStudentIdAndTestTime(studentId,testTime);
        return R.ok(score);
    }

    @PostMapping("/sumScore/save")
    public R<SumScore> save(@RequestBody SumScore sumScore) {
        SumScore score = sumScoreRepository.save(sumScore);
        return R.ok(score);
    }
}

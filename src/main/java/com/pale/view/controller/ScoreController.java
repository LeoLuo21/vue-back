package com.pale.view.controller;

import com.pale.view.model.Score;
import com.pale.view.repository.ScoreRepository;
import com.pale.view.repository.UserRepository;
import com.pale.view.response.R;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ScoreController {

	private final ScoreRepository scoreRepository;
	private final UserRepository userRepository;

	public ScoreController(ScoreRepository scoreRepository, UserRepository userRepository) {
		this.scoreRepository = scoreRepository;
		this.userRepository = userRepository;
	}

	@GetMapping("/score")
	public R<List<Score>> findHistoryScoresByStudentId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Long studentId = Long.valueOf((String) principal);

		List<Score> list = scoreRepository.findByStudentId(studentId);

		return R.ok(list);
    }

	@GetMapping("/score/subject/testTime")
	public R<Score> findScoreByStudentIdAndSubjectAndTestTime(String subject,String testTime) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Long studentId = Long.valueOf((String) principal);

		Score score = scoreRepository.findByStudentIdAndSubjectAndTestTime(studentId,subject,testTime);

		return R.ok(score);
    }

	@GetMapping("/score/testTime")
	public R<List<Score>> findScoresByStudentIdAndTestTime(String testTime) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Long studentId = Long.valueOf((String) principal);

		List<Score> score = scoreRepository.findByClazzIdAndTestTime(studentId,testTime);

		return R.ok(score);
	}

	@GetMapping("/score/classId/testTime")
	public R<Map<Long,List<Score>>> findScoresByClazzIdAndTestTime(Long ClazzId,String testTime) {
		List<Score> scores = scoreRepository.findByClazzIdAndTestTime(ClazzId,testTime);
		Map<Long,List<Score>> map = new HashMap<>();
		Set<Long> ids = scores.stream().map(score -> score.getStudentId()).collect(Collectors.toSet());
		for (Long id : ids) {
			map.put(id,new ArrayList<>());
		}
		for (Score score: scores) {
			map.get(score.getStudentId()).add(score);
		}
		return R.ok(map);
	}

}

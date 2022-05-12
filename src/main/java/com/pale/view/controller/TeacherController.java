package com.pale.view.controller;

import com.pale.view.model.Teacher;
import com.pale.view.repository.TeacherRepository;
import com.pale.view.response.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TeacherController {
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @PostMapping("/teacher/save")
    public R<Teacher> save (Teacher teacher) {
        Teacher saved = teacherRepository.save(teacher);
        return R.ok(saved);
    }
}

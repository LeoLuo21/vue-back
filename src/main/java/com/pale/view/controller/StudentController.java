package com.pale.view.controller;

import com.pale.view.model.Student;
import com.pale.view.model.User;
import com.pale.view.repository.StudentRepository;
import com.pale.view.repository.UserRepository;
import com.pale.view.response.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public StudentController(StudentRepository studentRepository,UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/student/save")
    public R<Student> insertStudent(@RequestBody Student student) {
        Student saved = studentRepository.save(student);
        User user = new User(saved.getId(),saved.getName(),encoder.encode("123456"),"student");
        userRepository.save(user);
        return R.ok(saved);
    }
}

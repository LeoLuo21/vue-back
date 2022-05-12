package com.pale.view.repository;

import com.pale.view.model.Student;
import org.springframework.data.repository.Repository;

public interface StudentRepository extends Repository<Student,Long> {
    Student save(Student student);
}

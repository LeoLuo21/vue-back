package com.pale.view.repository;

import com.pale.view.model.Teacher;
import org.springframework.data.repository.Repository;

public interface TeacherRepository extends Repository<Teacher,Long> {
    Teacher save(Teacher teacher);
}

package com.pale.view.repository;

import com.pale.view.model.PersonalSchedule;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PersonalScheduleRepository extends Repository<PersonalSchedule,Long> {
    PersonalSchedule save(PersonalSchedule personalSchedule);
    List<PersonalSchedule> findByStudentId(Long studentId);
}

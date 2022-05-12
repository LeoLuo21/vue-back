package com.pale.view.repository;

import com.pale.view.model.ClazzSchedule;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClazzScheduleRepository extends Repository<ClazzSchedule,Long> {
    ClazzSchedule save(ClazzSchedule clazzSchedule);
    List<ClazzSchedule> findByClazzId(Long clazzId);
    List<ClazzSchedule> findByTeacherId(Long teacherId);

}

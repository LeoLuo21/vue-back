package com.pale.view.repository;

import com.pale.view.model.Clazz;
import org.springframework.data.repository.Repository;

public interface ClazzRepository extends Repository<Clazz,Long> {
    Clazz save(Clazz clazz);
}

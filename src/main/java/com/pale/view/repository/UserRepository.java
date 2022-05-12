package com.pale.view.repository;

import com.pale.view.model.User;
import org.springframework.data.repository.Repository;
import java.util.Optional;
public interface UserRepository extends Repository<User,Long> {

    User save(User user);
    Optional<User> findById(Long id);
}

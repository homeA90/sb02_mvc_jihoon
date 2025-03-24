package com.sprint.mvc.repository;

import com.sprint.mvc.entity.User;

import java.util.List;

public interface UserRepository {

    User save(User user);
    User findByUserId(String userId);
    List<User> findAll();
    User update(User user);
    void delete(User user);
}

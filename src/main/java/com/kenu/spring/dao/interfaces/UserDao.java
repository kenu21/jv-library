package com.kenu.spring.dao.interfaces;

import com.kenu.spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    Optional<User> get(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> listUsers();
}

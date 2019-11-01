package com.kenu.spring.service.interfaces;

import com.kenu.spring.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    Optional<User> get(Long id);

    List<User> listUsers();

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}

package com.kenu.spring.service.interfaces;

import com.kenu.spring.entity.Role;

import java.util.Optional;

public interface RoleService {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}

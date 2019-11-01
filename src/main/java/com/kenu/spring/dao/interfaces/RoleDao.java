package com.kenu.spring.dao.interfaces;

import com.kenu.spring.entity.Role;
import java.util.Optional;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}

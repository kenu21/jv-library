package mate.academy.spring.dao.interfaces;

import java.util.Optional;

import mate.academy.spring.entity.Role;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}

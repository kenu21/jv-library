package mate.academy.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import mate.academy.spring.dao.interfaces.UserDao;
import mate.academy.spring.entity.Role;
import mate.academy.spring.entity.User;
import mate.academy.spring.service.interfaces.RoleService;
import mate.academy.spring.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public void add(User user) {
        List<Role> roles = user.getRoles();
        if (roles == null) {
            Optional<Role> roleUser = roleService.getRoleByName("ROLE_USER");
            Role role = roleUser.orElseThrow(NoSuchElementException::new);
            roles = new ArrayList<>();
            roles.add(role);
            user.setRoles(roles);
        }
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> get(Long id) {
        return userDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}

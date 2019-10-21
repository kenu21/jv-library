package mate.academy.spring.service.interfaces;

import java.util.List;

import mate.academy.spring.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}

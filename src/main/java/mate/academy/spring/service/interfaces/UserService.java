package mate.academy.spring.service.interfaces;

import java.util.List;
import java.util.Optional;

import mate.academy.spring.entity.User;

public interface UserService {
    void add(User user);

    Optional<User> get(Long id);

    List<User> listUsers();
}

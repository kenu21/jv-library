package mate.academy.spring.service;

import mate.academy.spring.dao.interfaces.RoleDao;
import mate.academy.spring.entity.Role;
import mate.academy.spring.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void add(Role role) {
        roleDao.add(role);
    }
}
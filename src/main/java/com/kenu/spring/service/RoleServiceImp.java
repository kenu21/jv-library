package com.kenu.spring.service;

import com.kenu.spring.dao.interfaces.RoleDao;
import com.kenu.spring.entity.Role;
import com.kenu.spring.service.interfaces.RoleService;

import java.util.Optional;

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

    @Transactional(readOnly = true)
    @Override
    public Optional<Role> getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }
}

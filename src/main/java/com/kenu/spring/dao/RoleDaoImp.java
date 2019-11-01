package com.kenu.spring.dao;

import com.kenu.spring.dao.interfaces.RoleDao;
import com.kenu.spring.entity.Role;

import java.util.Optional;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Role WHERE roleName=:roleName", Role.class);
        query.setParameter("roleName", roleName);
        try {
            Role role = query.getSingleResult();
            return Optional.of(role);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

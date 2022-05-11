package com.example.servingwebcontent.repository.named;

import com.example.servingwebcontent.repository.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<User> findAll() {
        return this.sessionFactory.getCurrentSession()
                .createNamedQuery("GET_ALL_USERS", User.class).getResultList();
    }

    public User findById(Long id) {
        return this.sessionFactory.getCurrentSession()
                .createNamedQuery("GET_USER_BY_ID", User.class).setParameter("id", id).getSingleResult();
    }

    public void deleteById(Long id) {
        this.sessionFactory.getCurrentSession().createNamedQuery("DELETE_FROM_USERS_BY_ID")
                .setParameter("id", id).executeUpdate();
    }
}

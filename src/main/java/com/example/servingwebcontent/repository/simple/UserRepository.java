package com.example.servingwebcontent.repository.simple;

import com.example.servingwebcontent.repository.entity.User;
import org.hibernate.Session;
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
        return this.sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    public User findById(Long id) {
        return this.sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void deleteById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.remove(user);
    }
}

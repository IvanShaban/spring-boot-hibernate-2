package com.example.servingwebcontent.repository.criteria;

import com.example.servingwebcontent.repository.entity.Device;
import com.example.servingwebcontent.repository.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<User> findAll() {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    public User findById(Long id) {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

        Query<User> query = this.sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    public void deleteById(Long id) {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = criteriaBuilder.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.from(User.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));

        this.sessionFactory.getCurrentSession().createQuery(criteriaDelete).executeUpdate();
    }
}

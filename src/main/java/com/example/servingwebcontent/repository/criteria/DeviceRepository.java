package com.example.servingwebcontent.repository.criteria;

import com.example.servingwebcontent.repository.entity.Device;
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
public class DeviceRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Device device) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(device);
    }

    public List<Device> findAll() {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
        Root<Device> root = criteriaQuery.from(Device.class);
        criteriaQuery.select(root);

        Query<Device> query = this.sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    public Device findById(Long id) {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Device> criteriaQuery = criteriaBuilder.createQuery(Device.class);
        Root<Device> root = criteriaQuery.from(Device.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));

        Query<Device> query = this.sessionFactory.getCurrentSession().createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    public void deleteById(Long id) {
        CriteriaBuilder criteriaBuilder = this.sessionFactory.getCriteriaBuilder();
        CriteriaDelete<Device> criteriaDelete = criteriaBuilder.createCriteriaDelete(Device.class);
        Root<Device> root = criteriaDelete.from(Device.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), id));

        this.sessionFactory.getCurrentSession().createQuery(criteriaDelete).executeUpdate();
    }
}

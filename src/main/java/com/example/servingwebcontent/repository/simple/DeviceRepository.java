package com.example.servingwebcontent.repository.simple;

import com.example.servingwebcontent.repository.entity.Device;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class DeviceRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Device device) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(device);
    }

    public List<Device> findAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Device", Device.class).list();
    }

    public Device findById(Long id) {
        return this.sessionFactory.getCurrentSession().get(Device.class, id);
    }

    public void deleteById(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Device device = session.get(Device.class, id);
        session.remove(device);
    }
}

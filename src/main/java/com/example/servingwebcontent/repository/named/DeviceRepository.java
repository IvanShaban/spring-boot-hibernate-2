package com.example.servingwebcontent.repository.named;

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
        return this.sessionFactory.getCurrentSession()
                .createNamedQuery("GET_ALL_DEVICES", Device.class).getResultList();
    }

    public Device findById(Long id) {
        return this.sessionFactory.getCurrentSession()
                .createNamedQuery("GET_DEVICE_BY_ID", Device.class).setParameter("id", id).getSingleResult();
    }

    public void deleteById(Long id) {
        this.sessionFactory.getCurrentSession().createNamedQuery("DELETE_FROM_DEVICES_BY_ID")
                .setParameter("id", id).executeUpdate();
    }
}

package br.com.test.xbrain.xbrequests.dao;

import br.com.test.xbrain.xbrequests.entity.Delivery;
import br.com.test.xbrain.xbrequests.entity.Request;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DeliveryDAO implements IDeliveryDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Delivery> getDeliveries() {
        List<Delivery> resultList = entityManager.createQuery("FROM Delivery", Delivery.class).getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public Delivery createDelivery(Delivery delivery) {
        entityManager.persist(delivery);
        entityManager.flush();
        return delivery;
    }

}
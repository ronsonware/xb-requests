package br.com.test.xbrain.xbrequests.dao;

import br.com.test.xbrain.xbrequests.entity.Request;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RequestDAO implements IRequestDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Request> getRequests() {
        List<Request> resultList = entityManager.createQuery("FROM Request", Request.class).getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public Request createRequest(Request request) {
        entityManager.persist(request);
        entityManager.flush();
        return request;
    }

}
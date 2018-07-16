package br.com.test.xbrain.xbrequests.listener;

import br.com.test.xbrain.xbrequests.dao.IDeliveryDAO;
import br.com.test.xbrain.xbrequests.dao.IRequestDAO;
import br.com.test.xbrain.xbrequests.entity.Delivery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RequestListener {


    @Autowired
    private IRequestDAO requestDAO;

    @Autowired
    private IDeliveryDAO deliveryDAO;

    private static final Logger log = LogManager.getLogger(RequestListener.class);

    public RequestListener(IRequestDAO requestDao, IDeliveryDAO deliveryDAO) {
        this.requestDAO = requestDao;
        this.deliveryDAO = deliveryDAO;
    }


    public void receiveMessage(Map<String, String> obj) {
        log.info("Delivery Received...");

        Delivery delivery = new Delivery(Integer.valueOf(obj.get("requestId")), obj.get("adress"));

        deliveryDAO.createDelivery(delivery);


        log.info("Delivery saved...");
    }
}

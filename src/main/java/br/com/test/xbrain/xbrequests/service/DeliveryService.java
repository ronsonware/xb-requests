package br.com.test.xbrain.xbrequests.service;

import br.com.test.xbrain.xbrequests.XbRequestsApplication;
import br.com.test.xbrain.xbrequests.dao.DeliveryDAO;
import br.com.test.xbrain.xbrequests.dao.IDeliveryDAO;
import br.com.test.xbrain.xbrequests.dao.IRequestDAO;
import br.com.test.xbrain.xbrequests.dto.ApiDTOBuilder;
import br.com.test.xbrain.xbrequests.dto.DeliveryDTO;
import br.com.test.xbrain.xbrequests.dto.RequestDTO;
import br.com.test.xbrain.xbrequests.entity.Delivery;
import br.com.test.xbrain.xbrequests.entity.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeliveryService implements IDeliveryService {


    @Autowired
    private IDeliveryDAO deliveryDAO;


    @Override
    public List<DeliveryDTO> getAllDeliveries() {
        List<Delivery> entities = deliveryDAO.getDeliveries();
        List<DeliveryDTO> deliveries = new ArrayList<DeliveryDTO>();

        Iterator<Delivery> iterator = entities.iterator();

        while(iterator.hasNext()) {
            Delivery delivery = iterator.next();
            deliveries.add(ApiDTOBuilder.deliveryToDeliveryDTO(delivery));
        }
        return deliveries;
    }




}
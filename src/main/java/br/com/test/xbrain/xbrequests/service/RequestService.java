package br.com.test.xbrain.xbrequests.service;

import br.com.test.xbrain.xbrequests.XbRequestsApplication;
import br.com.test.xbrain.xbrequests.dao.IRequestDAO;
import br.com.test.xbrain.xbrequests.dto.ApiDTOBuilder;
import br.com.test.xbrain.xbrequests.dto.RequestDTO;
import br.com.test.xbrain.xbrequests.entity.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RequestService implements IRequestService {

    private static final Logger log = LoggerFactory.getLogger(RequestService.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IRequestDAO requestDAO;

    @Autowired
    public RequestService(IRequestDAO requestDAO, RabbitTemplate rabbitTemplate) {
        this.requestDAO = requestDAO;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public List<RequestDTO> getAllRequests() {
        List<Request> entities = requestDAO.getRequests();
        List<RequestDTO> requests = new ArrayList<RequestDTO>();

        Iterator<Request> iterator = entities.iterator();

        while(iterator.hasNext()) {
            Request request = iterator.next();
            requests.add(ApiDTOBuilder.requestToRequestDTO(request));
        }
        return requests;
    }


    @Override
    public void createRequest(RequestDTO requestDTO) {
        Request request = requestDAO.createRequest(ApiDTOBuilder.requestDTOToRequest(requestDTO));
        this.sendRequest(request);
    }

    @Override
    public void sendRequest(Request request) {
        Map<String, String> actionmap = new HashMap<>();
        actionmap.put("adress", request.getDeliveryAdress());
        actionmap.put("requestId", String.valueOf(request.getRequestId()));

        log.info("Sending delivery...");

        rabbitTemplate.convertAndSend(XbRequestsApplication.REQUEST_QUEUE, actionmap);
    }

}
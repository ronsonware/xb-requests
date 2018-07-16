package br.com.test.xbrain.xbrequests.service;

import br.com.test.xbrain.xbrequests.dto.RequestDTO;
import br.com.test.xbrain.xbrequests.entity.Request;

import java.util.List;

public interface IRequestService {

    public List<RequestDTO> getAllRequests();

    public void createRequest(RequestDTO request);

    void sendRequest(Request id);

}

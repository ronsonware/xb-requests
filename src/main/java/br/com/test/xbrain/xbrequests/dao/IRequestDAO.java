package br.com.test.xbrain.xbrequests.dao;

import br.com.test.xbrain.xbrequests.entity.Request;

import java.util.List;

public interface IRequestDAO {

    public List<Request> getRequests();

    public Request createRequest(Request request);
}

package br.com.test.xbrain.xbrequests.dao;

import br.com.test.xbrain.xbrequests.entity.Delivery;

import java.util.List;

public interface IDeliveryDAO {

    public List<Delivery> getDeliveries();

    public Delivery createDelivery(Delivery delivery);
}

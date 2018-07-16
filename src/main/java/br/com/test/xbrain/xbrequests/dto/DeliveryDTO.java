package br.com.test.xbrain.xbrequests.dto;

import br.com.test.xbrain.xbrequests.entity.Product;

import java.util.List;

public class DeliveryDTO {

    private Integer deliveryId;
    private Integer requestId;
    private String deliveryAdress;

    public DeliveryDTO(Integer deliveryId, Integer requestId, String deliveryAdress) {
        this.deliveryId = deliveryId;
        this.requestId = requestId;
        this.deliveryAdress = deliveryAdress;
    }

    public DeliveryDTO(Integer requestId, String deliveryAdress) {
        this.requestId = requestId;
        this.deliveryAdress = deliveryAdress;
    }

    public DeliveryDTO() {}


    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }
}
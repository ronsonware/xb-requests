package br.com.test.xbrain.xbrequests.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "deliveries")
@Inheritance(strategy = InheritanceType.JOINED)
public class Delivery {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer deliveryId;

    @Column(nullable = false)
    private Integer requestId;

    @Column(nullable = false)
    private String deliveryAdress;

    public Delivery(Integer requestId, String deliveryAdress) {
        this.requestId = requestId;
        this.deliveryAdress = deliveryAdress;
    }

    public Delivery() {}


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
package br.com.test.xbrain.xbrequests.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "requests")
@Inheritance(strategy = InheritanceType.JOINED)
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer requestId;

    @Column(nullable = false)
    private Integer clientCode;

    @Transient
    private String deliveryAdress;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Product> products;

    @Column(nullable = false)
    private Double value;

    public Request(Integer clientCode, String deliveryAdress, Double value, List<Product> products) {
        this.clientCode = clientCode;
        this.deliveryAdress = deliveryAdress;
        this.products = products;
        this.value = value;
    }

    public Request() {
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getClientCode() {
        return clientCode;
    }

    public void setClientCode(Integer clientCode) {
        this.clientCode = clientCode;
    }

    public String getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(String deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
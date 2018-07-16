package br.com.test.xbrain.xbrequests.dto;

import br.com.test.xbrain.xbrequests.entity.Product;

import java.util.List;

public class RequestDTO {

    private Integer requestId;
    private Integer clientCode;
    private String deliveryAdress;
    private List<Product> products;
    private Double value;

    public RequestDTO(Integer requestId, Integer clientCode, String deliveryAdress, Double value, List<Product> products) {
        this.requestId = requestId;
        this.clientCode = clientCode;
        this.deliveryAdress = deliveryAdress;
        this.products = products;
        this.value = value;
    }

    public RequestDTO(Integer clientCode, String deliveryAdress, Double value, List<Product> products) {
        this.clientCode = clientCode;
        this.deliveryAdress = deliveryAdress;
        this.products = products;
        this.value = value;
    }

    public RequestDTO() {}


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
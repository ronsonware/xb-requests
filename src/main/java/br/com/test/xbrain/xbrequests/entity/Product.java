package br.com.test.xbrain.xbrequests.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer productId;


    @Column(nullable = false, unique = true)
    private Integer code;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Request> requests;

    public Product() {}

    public Product(Integer code) {
        this.code = code;
    }

    public Product(Integer code, List<Request> requests) {
        this.code = code;
        this.requests = requests;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
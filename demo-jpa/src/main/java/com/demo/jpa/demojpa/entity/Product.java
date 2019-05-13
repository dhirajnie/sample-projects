package com.demo.jpa.demojpa.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Product {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Integer id;
    @Version
    private Integer version;
    private String productName;
    private String description;
    private String imageUrl;
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    Order order;


    public Product()
    {
    }


    public Product( String productName, String description, String imageUrl, BigDecimal price )
    {
        this.productName = productName;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Order getOrder()
    {
        return order;
    }


    public void setOrder( Order order )
    {
        this.order = order;
    }
}

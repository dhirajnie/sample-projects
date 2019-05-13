package com.demo.jpa.demojpa.entity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table (name = "order_details")
public class Order
{
    @Id
    @Column (name = "order_id")
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    String orderdetails;
    @OneToMany (mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> productList;

    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn (name = "customerId")
    Customer customer;


    public Order()
    {
    }


    public Order( Integer id, Integer userId, String orderdetails )
    {
        this.id = id;
        this.userId = userId;
        this.orderdetails = orderdetails;
    }


    public Integer getId()
    {
        return id;
    }


    public void setId( Integer id )
    {
        this.id = id;
    }


    public Integer getUserId()
    {
        return userId;
    }


    public void setUserId( Integer userId )
    {
        this.userId = userId;
    }


    public String getOrderdetails()
    {
        return orderdetails;
    }


    public void setOrderdetails( String orderdetails )
    {
        this.orderdetails = orderdetails;
    }


    public List<Product> getProductList()
    {
        return productList;
    }


    public void setProductList( List<Product> productList )
    {
        this.productList = productList;
    }


    public Customer getCustomer()
    {
        return customer;
    }


    public void setCustomer( Customer customer )
    {
        this.customer = customer;
    }



}

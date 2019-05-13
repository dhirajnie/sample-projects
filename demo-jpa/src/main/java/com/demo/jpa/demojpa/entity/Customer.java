package com.demo.jpa.demojpa.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "customer_details")
public class Customer
{
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    Integer customerId;
    String customerName;
    String address;
    Integer phoneNumber;

    @OneToMany(mappedBy = "customer")
    List<Order> orderList;


    public Customer( Integer customerId, String customerName, String address, Integer phoneNumber )
    {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Customer()
    {
    }


    public Integer getCustomerId()
    {
        return customerId;
    }


    public void setCustomerId( Integer customerId )
    {
        this.customerId = customerId;
    }


    public String getCustomerName()
    {
        return customerName;
    }


    public void setCustomerName( String customerName )
    {
        this.customerName = customerName;
    }


    public String getAddress()
    {
        return address;
    }


    public void setAddress( String address )
    {
        this.address = address;
    }


    public Integer getPhoneNumber()
    {
        return phoneNumber;
    }


    public void setPhoneNumber( Integer phoneNumber )
    {
        this.phoneNumber = phoneNumber;
    }


    public List<Order> getOrderList()
    {
        return orderList;
    }


    public void setOrderList( List<Order> orderList )
    {
        this.orderList = orderList;
    }


}

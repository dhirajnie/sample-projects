package com.demo.jpa.demojpa.repository;

import com.demo.jpa.demojpa.entity.Customer;
import com.demo.jpa.demojpa.entity.Order;
import com.demo.jpa.demojpa.entity.Product;
import org.springframework.data.repository.CrudRepository;


public interface OrderRepository  extends CrudRepository<Order,Integer>
{
}

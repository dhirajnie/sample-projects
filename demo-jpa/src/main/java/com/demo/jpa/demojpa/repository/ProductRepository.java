package com.demo.jpa.demojpa.repository;


import com.demo.jpa.demojpa.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends CrudRepository<Product,Integer>
{
}

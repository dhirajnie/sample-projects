package com.demo.jpa.demojpa.repository;

import com.demo.jpa.demojpa.entity.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer,Integer>
{

}

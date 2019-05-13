package com.security.demo.repository;

import com.security.demo.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
public interface CustomerRepository extends CrudRepository<User,Integer>
{

}

package com.security.demo.repository;

import com.security.demo.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;


@Configuration
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByName( String userName );

    User saveAndFlush( User user );
}

package com.security.demo.service;

import com.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.security.demo.entities.CustomerUser;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AppUserDetailsServiceDAO implements UserDetailsService
{

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {  //todo: call MYSQL for authenticatoin
        System.out.println("userName called "+username);
        System.out.println( "_______________1111" );
        //Optional<UserDetails> userDetails = userRepository.findById( 1 );
        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<>();
        auths.add( new SimpleGrantedAuthority( "ROLE_ADMIN" ) );

        return new CustomerUser( "name", "abc@gmail.com", "name", "name", "shukla", true, auths );
    }

}

package com.security.demo.controller;

import com.security.demo.configuration.AccessToken;
import com.security.demo.entities.User;
import com.security.demo.entities.Role;
import com.security.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@Controller
@RequestMapping ("/test")
public class MyController
{
        @Autowired UserRepository userRepository;

    @RequestMapping (value = "/post", method = RequestMethod.GET)
    ResponseEntity<?> handlerMethod( AccessToken accessToken )
    {



        HttpHeaders httpHeaders = new HttpHeaders();
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);
            httpHeaders.add( "uploadTime", String.valueOf( System.currentTimeMillis() ) );

        System.out.println( "Controller called   " );
//        System.out.printf( accessToken.toString() );
//        Role role = new Role( 1,"ROLE_ADMIN" );
//        User user = new User( 1, "dhiraj", "a", "b", "shukla", 1, null );
//        Set<Role> roles= new LinkedHashSet<>(  );
//        roles.add( role );
//        user.setRoles( roles );
//
//        userRepository.save( user );
        return new ResponseEntity<>( "ok",httpHeaders, HttpStatus.OK );
    }

    @PreAuthorize( "hasAnyRole('ADMIN')" )
    @RequestMapping (value = "/secure", method = RequestMethod.GET)
    ResponseEntity<?> handlerMethod1( AccessToken accessToken )
    {
        System.out.println();
        System.out.println( "Controller called   " );
        System.out.printf( accessToken.toString() );
        return new ResponseEntity<>( "ok", HttpStatus.OK );

    }


}

package com.security.demo.controller;

import com.security.demo.configuration.AccessToken;
import com.security.demo.entities.User;

import com.security.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping ("/test")
public class MyController
{
    //    @Autowired
    //    CustomUserDetailService customUserDetailService;
    @Autowired UserRepository userCrudRepo;


    @RequestMapping (value = "/post", method = RequestMethod.POST)
    ResponseEntity<?> handlerMethod( AccessToken accessToken )
    {
        System.out.println( "Controller called   " );
        System.out.printf( accessToken.toString() );
        User user = new User( 1, "dhiraj", "a", "b", "shukla", 1, null );
     //   userCrudRepo.saveAndFlush( user );
        return new ResponseEntity<>( "ok", HttpStatus.OK );
    }


    @RequestMapping (value = "/pp", method = RequestMethod.POST)
    ResponseEntity<?> handlerMethod1( AccessToken accessToken )
    {
        System.out.println();
        System.out.println( "Controller called   " );
        System.out.printf( accessToken.toString() );
        return new ResponseEntity<>( "ok", HttpStatus.OK );

    }


}

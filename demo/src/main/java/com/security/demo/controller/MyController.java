package com.security.demo.controller;

import com.security.demo.configuration.AccessToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping ("/test")
public class MyController
{
    @RequestMapping (value = "/post", method = RequestMethod.POST)
    ResponseEntity<?> handlerMethod( AccessToken accessToken )
    {
        System.out.println( "Controller called   " );
        System.out.printf( accessToken.toString() );
        return new ResponseEntity<>( "ok", HttpStatus.OK );

    }


}

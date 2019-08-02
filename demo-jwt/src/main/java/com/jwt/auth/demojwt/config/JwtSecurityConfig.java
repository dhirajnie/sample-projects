package com.jwt.auth.demojwt.config;


import com.jwt.auth.demojwt.security.JwtAuthenticationTokenFilter;
import com.jwt.auth.demojwt.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.Collections;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter
{

    private JwtAuthenticationProvider authenticationProvider;

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter(){}


    @Bean
    public AuthenticationManager authenticationManager(){

        JwtAuthenticationFilter
        return new ProviderManager( Collections.singletonList( authenticationProvider ) )
    }
}
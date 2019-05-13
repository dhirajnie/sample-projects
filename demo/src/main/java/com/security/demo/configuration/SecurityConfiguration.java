//package com.security.demo.configuration;
//
//
//import com.security.demo.repository.UserRepository;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//
//@EnableJpaRepositories (basePackageClasses = UserRepository.class)
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigurati
// on extends WebSecurityConfigurerAdapter
//{
//
//    //UserDetailsService userDetailsService;
//
//
//    @Override
//    protected void configure( AuthenticationManagerBuilder auth ) throws Exception
//    {
//
//
//      //  auth.userDetailsService( userDetailsService );
//    }
//
//
//}

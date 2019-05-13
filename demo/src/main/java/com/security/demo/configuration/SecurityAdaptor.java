package com.security.demo.configuration;


import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*

Basic security info

 */

@EnableWebSecurity
public class SecurityAdaptor extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure( HttpSecurity httpSecurity ) throws Exception
    {
        httpSecurity.authorizeRequests()
             .antMatchers("**/post").hasRole( "DATA_ENRTY" ).and().httpBasic();
        httpSecurity.csrf().disable();

    }


    @Override
    protected void configure( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.inMemoryAuthentication().withUser( "dhiraj" ).password( "{noop}a" ).roles( "DATA_ENTRY" ).and().withUser( "ravi" )
            .password( "{noop}b" ).roles( "ADMIN" );


    }


}

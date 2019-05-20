package com.security.demo.configuration;

import com.security.demo.service.AppUserDetailsServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure( AuthenticationManagerBuilder  auth) throws Exception
    {
        auth.userDetailsService( userDetailsService ).passwordEncoder( new PasswordEncoder()
        {
            @Override
            public String encode( CharSequence charSequence )
            {
                return charSequence.toString();
            }


            @Override
            public boolean matches( CharSequence charSequence, String s )
            {
                return true;
            }
        } );

    }
    @Override
    protected void configure( HttpSecurity httpSecurity ) throws Exception
    {
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests().antMatchers( "**/secure/**" ).authenticated().anyRequest().permitAll().and().formLogin().permitAll();



    }

}
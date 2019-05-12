package com.oauthserver.authserver.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableResourceServer
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter
{

    @Bean
    @Override
    public UserDetailsService userDetailsService()
    {
        UserDetails user = User.builder().username( "user" ).password( "{noop}secret" ).roles( "USER" ).build();
        UserDetails userAdmin = User.builder().username( "admin" ).password( "{noop}secret" ).
            roles( "ADMIN" ).build();
        return new InMemoryUserDetailsManager( user, userAdmin );
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}

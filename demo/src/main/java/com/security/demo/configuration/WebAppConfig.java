package com.security.demo.configuration;

import com.security.demo.handlers.AccessTokenArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
public class WebAppConfig implements WebMvcConfigurer
{


    @Bean
    AccessTokenArgumentResolver accessTokenArgumentResolver()
    {
        return new AccessTokenArgumentResolver();

    }


    @Override
    public void addArgumentResolvers( List<HandlerMethodArgumentResolver> resolvers )
    {
        resolvers.add( accessTokenArgumentResolver() );
    }


}

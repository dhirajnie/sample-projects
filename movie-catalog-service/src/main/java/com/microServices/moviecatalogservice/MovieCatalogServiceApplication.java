package com.microServices.moviecatalogservice;

import com.microServices.moviecatalogservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MovieCatalogServiceApplication
{
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    public static void main( String[] args )
    {
        SpringApplication.run( MovieCatalogServiceApplication.class, args );



    }

}


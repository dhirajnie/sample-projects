package com.microServices.moviecatalogservice.controller;

import com.microServices.moviecatalogservice.model.CatalogItem;
import com.microServices.moviecatalogservice.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping ("/catalog")
public class MovieCatalogController
{
    //  WebClient.Builder builder;

    RestTemplate restTemplate;


    @Autowired
    public void setRestTemplate( RestTemplate restTemplate )
    {
        this.restTemplate = restTemplate;
    }


    @RequestMapping ("/{userId}")
    public List<CatalogItem> getCatalog( @PathVariable String userId )
    {
        Movie movie = restTemplate.getForObject( "http://movie-info-service/movies/1", Movie.class );
        System.out.println( movie );

        return Collections.singletonList( new CatalogItem( "Avengers", "Test", 10 ) );


    }


}

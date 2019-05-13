package com.demo.jpa.demojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication {


	@Autowired
	 ProductService productService;
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);


	}

}

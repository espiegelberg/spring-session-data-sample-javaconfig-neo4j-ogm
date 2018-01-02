package com.graphaware.springsessiondatasamplejavaconfigneo4jogm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.neo4j.config.annotation.web.http.EnableOgmHttpSession;

@Configuration
@EnableOgmHttpSession
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
}
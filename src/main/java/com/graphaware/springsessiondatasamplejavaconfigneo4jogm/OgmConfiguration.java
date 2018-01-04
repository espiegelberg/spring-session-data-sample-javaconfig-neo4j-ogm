package com.graphaware.springsessiondatasamplejavaconfigneo4jogm;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@org.springframework.context.annotation.Configuration
public class OgmConfiguration {
	
	@Value("${spring.data.neo4j.uri:bolt://neo4j:dev@localhost}")
	protected String neo4jUri;
	
	protected Configuration configuration;
	
	@Bean
	public Configuration configureOgm() {
		
		Configuration configuration = new Configuration.Builder().uri(neo4jUri).build();
		this.configuration = configuration;
		
        return configuration;
        
	}
	
	@Bean
	@DependsOn("configureOgm")
	@Qualifier("springSessionOgmSessionFactory")
	public SessionFactory sessionFactory() {
	    SessionFactory sessionFactory = new SessionFactory(configuration, "com.graphaware");
	    return sessionFactory;
	}

}
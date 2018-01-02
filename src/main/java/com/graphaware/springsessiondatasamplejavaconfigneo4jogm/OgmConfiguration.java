/*
 * Copyright (c) 2013-2017 GraphAware
 *
 * This file is part of the GraphAware Framework.
 *
 * GraphAware Framework is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

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
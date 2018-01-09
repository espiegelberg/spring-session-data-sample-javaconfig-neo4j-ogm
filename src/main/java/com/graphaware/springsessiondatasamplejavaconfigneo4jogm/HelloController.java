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

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index(final HttpServletRequest request, final HttpServletResponse response) {
    	
    	HttpSession session = request.getSession(true);
    	Enumeration<String> attributeNames = session.getAttributeNames();
    	
    	while (attributeNames.hasMoreElements()) {
    		
    		String attributeName = attributeNames.nextElement();
    		System.out.println("1) attributeName: " + attributeName);
    		
    	}
    	
    	Date now = new Date();
    	session.setAttribute("Hello", now);    	
    	session.setAttribute(now.toString(), now);
    	session.setAttribute("HelloString", now.toString());
    	session.setAttribute("HelloLong", 1L);
    	
    	attributeNames = session.getAttributeNames();
    	
    	while (attributeNames.hasMoreElements()) {
    		
    		String attributeName = attributeNames.nextElement();
    		System.out.println("2) attributeName: " + attributeName);
    		
    	}
    	
        return "Hello from Spring Boot";
        
    }

}
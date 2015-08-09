package com.knuthp.vaadin.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class Greeter {
	private static final Logger LOG = LoggerFactory.getLogger(Greeter.class);

	public Greeter() {
		LOG.info("Greeter()");
	}

	public String sayHello() {
		return "Hello from bean " + toString();
	}

}

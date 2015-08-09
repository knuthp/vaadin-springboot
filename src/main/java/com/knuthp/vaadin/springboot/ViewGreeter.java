package com.knuthp.vaadin.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class ViewGreeter {
	private static final Logger LOG = LoggerFactory
			.getLogger(ViewGreeter.class);

	public ViewGreeter() {
		LOG.info("ViewGreeter()");
	}

	public String sayHello() {
		return "Hello from a view scoped bean " + toString();

	}

}

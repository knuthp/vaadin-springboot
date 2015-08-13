package com.knuthp.vaadin.springboot.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CalculatorModel {
	private static final Logger LOG = LoggerFactory
			.getLogger(CalculatorModel.class);

	public CalculatorModel() {
		LOG.info("CalculatorModel created");
	}

	private double value = 0.0;

	public void clear() {
		value = 0.0;
	}

	public void add(double arg) {
		value += arg;
	}

	public void multiply(double arg) {
		value *= arg;
	}

	public void divide(double arg) {
		if (arg != 0.0) {
			value /= arg;
		}
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}

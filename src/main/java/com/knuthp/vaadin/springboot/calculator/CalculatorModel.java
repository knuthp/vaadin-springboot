package com.knuthp.vaadin.springboot.calculator;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class CalculatorModel {
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

package com.knuthp.vaadin.springboot.calculator;

public interface CalculatorView {
	void setDisplay(double value);

	interface CalculatorViewListener {
		void buttonClick(char operation);
	}

	void addListener(CalculatorViewListener listener);

}

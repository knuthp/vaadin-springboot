package com.knuthp.vaadin.springboot.mvp.calculator;

public interface MvpCalculatorView {
	void setDisplay(double value);

	interface CalculatorViewListener {
		void buttonClick(char operation);
	}

	void addListener(CalculatorViewListener listener);

}

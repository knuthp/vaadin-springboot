package com.knuthp.vaadin.springboot.calculator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.calculator.CalculatorView.CalculatorViewListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class CalculatorPresenter implements CalculatorViewListener {
	private static final Logger LOG = LoggerFactory
			.getLogger(CalculatorPresenter.class);
	CalculatorModel model;
	CalculatorView view;

	private double current = 0.0;
	private char lastOperationRequested = 'C';

	@Autowired
	public CalculatorPresenter(CalculatorModel model) {
		LOG.info("New CalculatorPresenter created");
		this.model = model;
	}

	public void setView(CalculatorView calculatorView) {
		this.view = calculatorView;
		view.setDisplay(current);
		view.addListener(this);
	}

	@PostConstruct
	void init() {
		LOG.info("init called (@PostContruct)");
	}

	@Override
	public void buttonClick(char operation) {
		if ('0' <= operation && operation <= '9') {
			current = current * 10 + Double.parseDouble("" + operation);
			view.setDisplay(current);
			return;
		}

		switch (lastOperationRequested) {
		case '+':
			model.add(current);
			break;
		case '-':
			model.add(-current);
			break;
		case '/':
			model.divide(current);
			break;
		case '*':
			model.multiply(current);
			break;
		case 'C':
			model.setValue(current);
			break;
		default:
			break;
		}

		lastOperationRequested = operation;
		current = 0.0;
		if (operation == 'C') {
			model.clear();
		}
		view.setDisplay(model.getValue());
	}

}

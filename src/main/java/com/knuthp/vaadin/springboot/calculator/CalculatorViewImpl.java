package com.knuthp.vaadin.springboot.calculator;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

@ViewScope
@SpringView(name = CalculatorViewImpl.VIEW_NAME)
public class CalculatorViewImpl extends CustomComponent implements
		CalculatorView, ClickListener, View {
	public static final String VIEW_NAME = "calculator";
	private static final Logger LOG = LoggerFactory
			.getLogger(CalculatorViewImpl.class);
	private Label display = new Label("0.0");

	@Autowired
	public CalculatorViewImpl(Presenter<CalculatorView> presenter,
			CalculatorModel model) {
		LOG.info("New CalculatorViewImpl created");
		presenter.setView(this);
		GridLayout layout = new GridLayout(4, 5);
		layout.addComponent(display, 0, 0, 3, 0);
		String[] operations = new String[] { "7", "8", "9", "/", "4", "5", "6",
				"*", "1", "2", "3", "-", "0", "=", "C", "+" };
		for (String caption : operations) {
			layout.addComponent(new Button(caption, this));
		}
		setCompositionRoot(layout);
	}

	@Override
	public void setDisplay(double value) {
		display.setValue(Double.toString(value));
	}

	List<CalculatorViewListener> listeners = new ArrayList<CalculatorView.CalculatorViewListener>();

	@Override
	public void addListener(CalculatorViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		for (CalculatorViewListener listener : listeners) {
			listener.buttonClick(event.getButton().getCaption().charAt(0));
		}

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}

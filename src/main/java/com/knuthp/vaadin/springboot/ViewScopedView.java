package com.knuthp.vaadin.springboot;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {
	private static final Logger LOG = LoggerFactory
			.getLogger(ViewScopedView.class);
	private static final long serialVersionUID = 1L;

	public final static String VIEW_NAME = "view";

	@Autowired
	private ViewGreeter viewGreeter;

	@Autowired
	private Greeter uiGreeter;

	@PostConstruct
	void init() {
		LOG.info("init()");
		setMargin(true);
		setSpacing(true);
		addComponent(new Label("This is a view scoped view" + toString()));
		addComponent(new Label(uiGreeter.sayHello()));
		addComponent(new Label(viewGreeter.sayHello()));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}

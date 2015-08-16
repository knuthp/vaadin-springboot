package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@ViewScope
@SpringView(name = PlaceViewImpl.VIEW_NAME)
public class PlaceViewImpl extends VerticalLayout implements PlaceView, View {
	public static final String VIEW_NAME = "Place";
	private static final Logger LOG = LoggerFactory
			.getLogger(PlaceViewImpl.class);
	private final List<PlaceViewListener> listeners = new ArrayList<PlaceView.PlaceViewListener>();

	@Autowired
	public PlaceViewImpl(Presenter<PlaceView> presenter) {
		addComponent(new Label("PLace"));
		presenter.setView(this);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		LOG.info("event.parameters={}", event.getParameters());
		listeners.forEach(listener -> listener.placeChanged(event
				.getParameters()));
	}

	@Override
	public void setPlace(PlaceDetails placeDetails) {
		addComponent(new Label(placeDetails.getName()));
		addComponent(new Label(placeDetails.getDistrict()));
	}

	@Override
	public void addListener(PlaceViewListener listener) {
		listeners.add(listener);
	}
}

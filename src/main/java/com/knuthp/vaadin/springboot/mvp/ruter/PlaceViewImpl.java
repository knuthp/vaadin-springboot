package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
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
		BeanItem<PlaceDetails> placeItem = new BeanItem<PlaceDetails>(
				placeDetails);
		FormLayout form = new FormLayout();
		FieldGroup binder = new FieldGroup(placeItem);
		form.addComponent(binder.buildAndBind("Id", "id"));
		form.addComponent(binder.buildAndBind("Name", "name"));
		form.addComponent(binder.buildAndBind("District", "district"));
		form.addComponent(binder.buildAndBind("Place type", "placeType"));
		form.addComponent(binder.buildAndBind("RealTime info", "realTimeStop"));
		addComponent(form);

		BeanContainer<String, Line> lineBeans = new BeanContainer<String, Line>(
				Line.class);
		lineBeans.setBeanIdProperty("id");
		lineBeans.addAll(placeDetails.getLines().values());

		Table lineTable = new Table("Lines", lineBeans);
		addComponent(lineTable);

	}

	@Override
	public void addListener(PlaceViewListener listener) {
		listeners.add(listener);
	}
}

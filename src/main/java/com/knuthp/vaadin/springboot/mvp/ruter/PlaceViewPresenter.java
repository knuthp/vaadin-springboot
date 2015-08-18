package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.knuthp.ruter.model.PlaceDetails;
import com.knuthp.ruter.model.RuterGateway;
import com.knuthp.vaadin.springboot.mvp.Presenter;
import com.knuthp.vaadin.springboot.mvp.ruter.PlaceView.PlaceViewListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class PlaceViewPresenter implements Presenter<PlaceView>,
		PlaceViewListener {

	private RuterGateway ruterGateway;
	private PlaceView view;

	@Autowired
	public PlaceViewPresenter(RuterGateway ruterGateway) {
		this.ruterGateway = ruterGateway;
	}

	@Override
	public void setView(PlaceView view) {
		this.view = view;
		view.addListener(this);
	}

	@Override
	public void placeChanged(String id) {
		List<PlaceDetails> places = ruterGateway.getPlaces(id);
		view.setPlace(places.get(0));
	}

}

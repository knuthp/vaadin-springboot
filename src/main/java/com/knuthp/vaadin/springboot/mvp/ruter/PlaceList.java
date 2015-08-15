package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class PlaceList {
	private final RuterGateway ruterGateway;

	@Autowired
	public PlaceList(final RuterGateway ruterGateway) {
		this.ruterGateway = ruterGateway;
	}

	public List<PlaceLight> getPlaceList() {
		return ruterGateway.getStopsRuter();
	}

}

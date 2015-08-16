package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private final LineLight lineLight;
	private final RuterGateway ruterGateway;

	public Line(RuterGateway ruterGateway, String id) {
		this.ruterGateway = ruterGateway;
		lineLight = ruterGateway.getLine(id);
	}

	public List<Place> getStops() {
		List<PlaceLight> lineStops = ruterGateway.getLineStops(lineLight
				.getId());
		List<Place> placeList = new ArrayList<Place>();
		lineStops.forEach(place -> placeList.add(new Place(ruterGateway, place
				.getId())));
		return placeList;
	}

}

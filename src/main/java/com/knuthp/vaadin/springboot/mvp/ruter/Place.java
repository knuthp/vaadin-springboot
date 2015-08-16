package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.List;

public class Place {

	private PlaceDetails placeDetails;
	private RuterGateway ruterGateway;

	public Place(RuterGateway ruterGateway, String id) {
		this.ruterGateway = ruterGateway;
		List<PlaceDetails> places = ruterGateway.getPlaces(id);
		placeDetails = places.get(0);
	}

	public String getId() {
		return placeDetails.getId();
	}

	public String getDistrict() {
		return placeDetails.getDistrict();
	}

	public List<Line> getLines() {
		List<Line> lineList = new ArrayList<Line>();
		for (String lineId : placeDetails.getLines().keySet()) {
			lineList.add(new Line(ruterGateway, lineId));
		}
		return null;
	}

}

package com.knuthp.ruter.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

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

	public String getName() {
		return placeDetails.getName();
	}

	public List<Line> getLines() {
		List<Line> lineList = new ArrayList<Line>();
		for (String lineId : placeDetails.getLines().keySet()) {
			lineList.add(new Line(ruterGateway, lineId));
		}
		return null;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public Point2D getPos() {
		return new Point2D.Double(Double.parseDouble(placeDetails.getX()),
				Double.parseDouble(placeDetails.getY()));
	}

}

package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final LineLight lineLight;
	private final RuterGateway ruterGateway;
	private List<Place> placeList;

	public Line(RuterGateway ruterGateway, String id) {
		this.ruterGateway = ruterGateway;
		lineLight = ruterGateway.getLine(id);
	}

	public Line(RuterGateway ruterGateway, LineLight lineLight) {
		this.ruterGateway = ruterGateway;
		this.lineLight = lineLight;
	}

	public String getId() {
		return lineLight.getId();
	}

	public String getName() {
		return lineLight.getName();
	}

	public List<Place> getStops() {
		if (placeList == null) {
			List<PlaceLight> lineStops = ruterGateway.getLineStops(lineLight
					.getId());
			placeList = new ArrayList<Place>();
			lineStops.forEach(place -> placeList.add(new Place(ruterGateway,
					place.getId())));
		}
		return placeList;
	}

	public Place getStart() {
		return getStops().get(0);
	}

	public Place getEnd() {
		return getStops().get(getStops().size() - 1);
	}

	public double getDistanceByLine() {
		double distance = 0;
		for (int i = 0; i < placeList.size() - 1; i++) {
			Place current = placeList.get(i);
			Place next = placeList.get(i + 1);
			distance += current.getPos().distance(next.getPos());

		}
		return distance;
	}
}

package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelMain {

	private static final Logger LOG = LoggerFactory.getLogger(ModelMain.class);

	public static void main(String[] args) {
		RuterGateway ruterGateway = new RuterGateway();
		List<LineLight> lines = ruterGateway.getLines();
		LOG.info("lines.size={}", lines.size());
		for (LineLight lineLight : lines) {
			if (lineLight.getTransportation() == TransportationType.TRAIN) {
				List<PlaceLight> lineStops = ruterGateway
						.getLineStops(lineLight.getId());

				LOG.info(
						"Line.id={}, line.name={}, lineStops.size={}, lineStops.from={}, lineStops.to={}",
						lineLight.getId(), lineLight.getName(), lineStops
								.size(), lineStops.get(0).getName(), lineStops
								.get(lineStops.size() - 1).getName());
			}
		}

	}
}

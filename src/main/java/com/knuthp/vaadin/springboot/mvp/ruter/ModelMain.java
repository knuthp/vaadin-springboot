package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelMain {

	private static final Logger LOG = LoggerFactory.getLogger(ModelMain.class);

	public static void main(String[] args) {
		ToStringBuilder.setDefaultStyle(ToStringStyle.SIMPLE_STYLE);
		RuterGateway ruterGateway = new RuterGateway();
		Line line = new Line(ruterGateway, "9114");
		LOG.info("id={}, name={}, start={}, end={}, distance={}", line.getId(),
				line.getName(), line.getStart().getName(), line.getEnd()
						.getName(), line.getDistanceByLine());

		// listTrainLinesWithStartAndStop(ruterGateway);

	}

	private static void listTrainLinesWithStartAndStop(RuterGateway ruterGateway) {
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

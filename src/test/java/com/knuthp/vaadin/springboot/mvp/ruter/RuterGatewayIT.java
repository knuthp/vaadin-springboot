package com.knuthp.vaadin.springboot.mvp.ruter;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;

public class RuterGatewayIT {

	private RuterGateway ruterGateway;

	@Test
	public void testOneStop() {
		RuterGateway ruterGateway = new RuterGateway();
		PlaceLight stop = ruterGateway.getStop("1001");

		System.out.println(stop);

		fail("Not yet implemented");
	}

	@Test
	public void testRuterStops() {
		List<PlaceLight> stops = ruterGateway.getStopsRuter();

		System.out.println(stops.size());

	}

	@Test
	public void testGetPlace() throws Exception {
		List<PlaceDetails> places = ruterGateway.getPlaces("1250100");

		System.out.println(places);

		fail("Not yet implemented");
	}

	@Test
	public void testLines() throws Exception {
		List<LineLight> lines = ruterGateway.getLines();

		System.out.println(lines);

		fail("Not yet implemented");
	}

	@Test
	public void testLineData() throws Exception {
		LineLight line = ruterGateway.getLine("9110");

		System.out.println(line);

		fail("Not yet implemented");

	}

	@Test
	public void testLineStops() throws Exception {
		List<PlaceLight> lineStops = ruterGateway.getLineStops("9110");

		System.out.println(lineStops);

		fail("Not yet implemented");
	}

	@Test
	public void testGetStopVisits() throws Exception {
		List<MonitoredStopVisitDetails> realTimeData = ruterGateway
				.getDepartures("2200500");

		System.out.println(realTimeData);

		fail("Not yet implemented");
	}

	@Before
	public void setUp() {
		ruterGateway = new RuterGateway();
		ReflectionToStringBuilder
				.setDefaultStyle(ToStringStyle.SHORT_PREFIX_STYLE);
	}

}

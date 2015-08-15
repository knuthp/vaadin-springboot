package com.knuthp.vaadin.springboot.mvp.ruter;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RuterGatewayIT {

	private RuterGateway ruterGateway;

	@Test
	public void testOneStop() {
		RuterGateway ruterGateway = new RuterGateway();
		Place stop = ruterGateway.getStop("1001");

		System.out.println(stop);

		fail("Not yet implemented");
	}

	@Test
	public void testRuterStops() {
		List<Place> stops = ruterGateway.getStopsRuter();

		System.out.println(stops.size());
	}

	@Before
	public void setUp() {
		ruterGateway = new RuterGateway();
	}

}

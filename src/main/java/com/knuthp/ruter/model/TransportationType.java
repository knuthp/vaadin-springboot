package com.knuthp.ruter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransportationType {
	WALKING(0), AIRPORT_BUS(1), BUS(2), DUMMY(3), AIRPORT_TRAIN(4), BOAT(5), TRAIN(
			6), TRAM(7), METRO(8);

	private final int value;

	TransportationType(int value) {
		this.value = value;
	}

	@JsonValue
	public int value() {
		return value;
	}

	@JsonCreator
	public static TransportationType fromValue(int typeCode) {
		for (TransportationType c : TransportationType.values()) {
			if (c.value == typeCode) {
				return c;
			}
		}
		throw new IllegalArgumentException("Invalid Status type code: "
				+ typeCode);
	}

}

package com.knuthp.vaadin.springboot.mvp.ruter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceDetails {
	private final String id;
	private final String district;
	private final String name;
	private final String placeType;
	private final boolean hub;
	private final String shortName;
	private final String x;
	private final String y;
	private final boolean alightingAllowed;
	private final boolean boardingAllowed;
	// TODO deviations
	private final Map<String, LineLight> lines;
	private final boolean realTimeStop;

	public PlaceDetails(@JsonProperty("ID") String id,
			@JsonProperty("District") String district,
			@JsonProperty("Name") String name,
			@JsonProperty("PlaceType") String placeType,
			@JsonProperty("IsHub") boolean hub,
			@JsonProperty("ShortName") String shortName,
			@JsonProperty("X") String x, @JsonProperty("Y") String y,
			@JsonProperty("AlightingAllowed") boolean alightingAllowed,
			@JsonProperty("BoardingAllowe") boolean boardingAllowed,
			@JsonProperty("Lines") LineLight[] lines,
			@JsonProperty("RealTimeStop") boolean realTimeStop) {
		super();
		this.id = id;
		this.district = district;
		this.name = name;
		this.placeType = placeType;
		this.hub = hub;
		this.shortName = shortName;
		this.x = x;
		this.y = y;
		this.alightingAllowed = alightingAllowed;
		this.boardingAllowed = boardingAllowed;
		this.lines = Arrays.stream(lines).collect(
				Collectors.toMap(LineLight::getId, Function.identity()));

		this.realTimeStop = realTimeStop;
	}

	public String getId() {
		return id;
	}

	public String getDistrict() {
		return district;
	}

	public String getName() {
		return name;
	}

	public String getPlaceType() {
		return placeType;
	}

	public boolean isHub() {
		return hub;
	}

	public String getShortName() {
		return shortName;
	}

	public String getX() {
		return x;
	}

	public String getY() {
		return y;
	}

	public boolean isAlightingAllowed() {
		return alightingAllowed;
	}

	public boolean isBoardingAllowed() {
		return boardingAllowed;
	}

	public Map<String, LineLight> getLines() {
		return lines;
	}

	public boolean isRealTimeStop() {
		return realTimeStop;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

package com.knuthp.vaadin.springboot.mvp.ruter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineLight {
	private final String id;
	private final String name;
	private final String lineColour;
	private final String transportation;

	public LineLight(@JsonProperty("ID") String id,
			@JsonProperty("Name") String name,
			@JsonProperty("LineColour") String lineColour,
			@JsonProperty("Transportation") String transportation) {
		super();
		this.id = id;
		this.lineColour = lineColour;
		this.name = name;
		this.transportation = transportation;
	}

	public String getId() {
		return id;
	}

	public String getLineColour() {
		return lineColour;
	}

	public String getTransportation() {
		return transportation;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	public String getName() {
		return name;
	}

}

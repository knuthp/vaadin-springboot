package com.knuthp.vaadin.springboot.mvp.ruter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
	private final String id;
	private final String name;
	private final String shortName;
	private final int X;
	private final int y;

	public Place(@JsonProperty("ID") String id,
			@JsonProperty("Name") String name,
			@JsonProperty("ShortName") String shortName,
			@JsonProperty("X") int x, @JsonProperty("Y") int y) {
		super();
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		X = x;
		this.y = y;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

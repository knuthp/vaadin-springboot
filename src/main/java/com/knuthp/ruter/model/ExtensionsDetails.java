package com.knuthp.ruter.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtensionsDetails {

	private final String lineColour;

	public ExtensionsDetails(@JsonProperty("LineColour") String lineColour) {
		this.lineColour = lineColour;
	}

	public String getLineColour() {
		return lineColour;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

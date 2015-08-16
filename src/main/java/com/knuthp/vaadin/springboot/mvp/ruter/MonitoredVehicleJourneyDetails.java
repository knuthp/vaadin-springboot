package com.knuthp.vaadin.springboot.mvp.ruter;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonitoredVehicleJourneyDetails {
	private final String destinationName;
	private final String lineRef;
	private final String operatorRef;
	private final String publishedLineName;
	private final String vehicleJourneyName;
	private final String vehicleMode;
	private final String vehicleRef;

	public MonitoredVehicleJourneyDetails(
			@JsonProperty("DestinationName") String destinationName,
			@JsonProperty("LineRef") String lineRef,
			@JsonProperty("OperatorRef") String operatorRef,
			@JsonProperty("PublishedLineName") String publishedLineName,
			@JsonProperty("VehicleJourneyName") String vehicleJourneyName,
			@JsonProperty("VehicleMode") String vehicleMode,
			@JsonProperty("VehicleRef") String vehicleRef) {
		this.destinationName = destinationName;
		this.lineRef = lineRef;
		this.operatorRef = operatorRef;
		this.publishedLineName = publishedLineName;
		this.vehicleJourneyName = vehicleJourneyName;
		this.vehicleMode = vehicleMode;
		this.vehicleRef = vehicleRef;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public String getLineRef() {
		return lineRef;
	}

	public String getOperatorRef() {
		return operatorRef;
	}

	public String getPublishedLineName() {
		return publishedLineName;
	}

	public String getVehicleJourneyName() {
		return vehicleJourneyName;
	}

	public String getVehicleMode() {
		return vehicleMode;
	}

	public String getVehicleRef() {
		return vehicleRef;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

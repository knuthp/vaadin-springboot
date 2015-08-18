package com.knuthp.ruter.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonitoredStopVisitDetails {

	private final MonitoredVehicleJourneyDetails monitoredVehicleJourneyDetails;
	private final ExtensionsDetails extensions;

	public MonitoredStopVisitDetails(
			@JsonProperty("Extensions") ExtensionsDetails extensions,
			@JsonProperty("MonitoredVehicleJourney") MonitoredVehicleJourneyDetails monitoredVehicleJourneyDetails) {
		this.extensions = extensions;
		this.monitoredVehicleJourneyDetails = monitoredVehicleJourneyDetails;
	}

	public MonitoredVehicleJourneyDetails getMonitoredVehicleJourneyDetails() {
		return monitoredVehicleJourneyDetails;
	}

	public ExtensionsDetails getExtensions() {
		return extensions;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

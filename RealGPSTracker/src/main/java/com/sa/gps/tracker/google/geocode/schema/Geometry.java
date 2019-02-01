package com.sa.gps.tracker.google.geocode.schema;

import org.codehaus.jackson.annotate.JsonProperty;

public class Geometry {

	private Location location;
	@JsonProperty("location_type")
	private String locationType;
	private Viewport viewport;

	public void setLocation(Location location) {
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setViewport(Viewport viewport) {
		this.viewport = viewport;
	}

	public Viewport getViewport() {
		return viewport;
	}

}
package com.sa.gps.tracker.google.geocode.schema;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class AddressComponents {

	@JsonProperty("long_name")
	private String longName;
	@JsonProperty("short_name")
	private String shortName;
	private List<String> types;

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getLongName() {
		return longName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getTypes() {
		return types;
	}

}
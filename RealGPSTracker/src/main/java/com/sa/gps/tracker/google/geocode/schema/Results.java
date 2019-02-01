package com.sa.gps.tracker.google.geocode.schema;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

public class Results {

	@JsonProperty("address_components")
	private List<AddressComponents> addressComponents;
	@JsonProperty("formatted_address")
	private String formattedAddress;
	private Geometry geometry;
	@JsonProperty("place_id")
	private String placeId;
	private List<String> types;

	public void setAddressComponents(List<AddressComponents> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public List<AddressComponents> getAddressComponents() {
		return addressComponents;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getTypes() {
		return types;
	}

}
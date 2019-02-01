package com.sa.gps.tracker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GPSDataModel {

	@NotEmpty(message = "latitude is a mandatory parameter")
	private String latitude;
	@NotEmpty(message = "longitude is a mandatory parameter")
	private String longitude;
	@NotEmpty(message = "license plate is a mandatory parameter")
	private String licensePlate;
	private String vehicleType;
	private String vehicleBrand;

	public GPSDataModel(String latitude, String longitude, String licensePlate, String vehicleBrand,
			String vehicleType) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.licensePlate = licensePlate;
		this.vehicleBrand = vehicleBrand;
		this.vehicleType = vehicleType;
	}
	
	public GPSDataModel() {
	}
	
	


}

package com.sa.gps.tracker.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class GPSDataEntity {
	
	@Id
    @GeneratedValue
    @Column(name="position_id")
    private Long positionId;
	
	@Column(name="latitude")
    private String latitude;
	
	@Column(name="longitude")
    private String longitude;
	
	@Column(name="vehicle_id")
    private String vehicleId;
	
	@Column(name="vehicle_type")
    private String vehicleType;
	
	@Column(name="vehicle_brand")
    private String vehicleBrand;
	
	@Column(name="reg_id")
    private long regId;
	
	@Column(name="location_date")
    private LocalDate date;
	
	

	public GPSDataEntity(Long positionId, String latitude, String longitude, String vehicleId, String vehicleType,
			String vehicleBrand, long regId, LocalDate date) {
		super();
		this.positionId = positionId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.regId = regId;
		this.date = date;
	}



	public GPSDataEntity() {
	}

	
	
	
	

}

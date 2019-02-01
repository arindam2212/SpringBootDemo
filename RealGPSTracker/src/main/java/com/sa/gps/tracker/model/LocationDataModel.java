package com.sa.gps.tracker.model;

import java.util.List;

import com.sa.gps.tracker.google.geocode.schema.Results;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationDataModel {
	
	private List<Results> results;
	private String status;

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}

package com.sa.gps.tracker.service;

import java.io.ByteArrayInputStream;

import com.sa.gps.tracker.exception.TrackerException;
import com.sa.gps.tracker.model.GPSDataModel;
import com.sa.gps.tracker.model.LocationDataModel;

public interface GPSTrackerService {
	
	public long createDataLocation(GPSDataModel dataModel) throws TrackerException;
	public LocationDataModel getDataLocation(long registrationId, String latitude, String longitude) throws TrackerException, Exception;
	public ByteArrayInputStream generateReport(long regId);
}

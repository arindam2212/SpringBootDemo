package com.sa.gps.tracker.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sa.gps.tracker.exception.TrackerException;
import com.sa.gps.tracker.model.GPSDataModel;
import com.sa.gps.tracker.model.LocationDataModel;
import com.sa.gps.tracker.service.GPSTrackerService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "GPSTracker", description = "Real Time Location Tracking App")
public class GPSTrackerController {

	@Autowired
	private GPSTrackerService trackerService;
	

	/**
	 * This api will register the vehicle with required data provided
	 * 
	 * @param gpsDataModel
	 * @param channelId
	 * @param uuid
	 * @param country
	 * @param authorization
	 * @param clientId
	 * @param deviceId
	 * @return
	 */

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/gps/track/location")
	public long createLocation(@RequestBody GPSDataModel gpsDataModel, @RequestHeader("channel") String channelId,
			@RequestHeader("uuid") String uuid, @RequestHeader("country") String country,
			@RequestHeader("Authorization") String authorization, @RequestHeader("client_id") String clientId,
			@RequestHeader("device_id") String deviceId) {

		return trackerService.createDataLocation(gpsDataModel);

	}
	
	/**
	 * This api will return the current location of the GPS data(latitude,longitude) sent
	 * 
	 * @param registrationId
	 * @param latitude
	 * @param longitude
	 * @param channelId
	 * @param uuid
	 * @param country
	 * @param authorization
	 * @param clientId
	 * @param deviceId
	 * @return
	 * @throws TrackerException
	 * @throws Exception
	 */

	@GetMapping("/gps/track/location")
	@ResponseStatus(HttpStatus.OK)
	public LocationDataModel getLocation(@RequestParam("registration_id") long registrationId,
			@RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude,
			@RequestHeader("channel") String channelId, @RequestHeader("uuid") String uuid,
			@RequestHeader("country") String country, @RequestHeader("Authorization") String authorization,
			@RequestHeader("client_id") String clientId, @RequestHeader("device_id") String deviceId)
			throws TrackerException, Exception {

		return trackerService.getDataLocation(registrationId, latitude, longitude);

	}
	
	
	/**
	 * This api will generate the report of vehicle location
	 * 
	 * 
	 * @param response
	 * @param registrationId
	 * @param channelId
	 * @param uuid
	 * @param country
	 * @param authorization
	 * @param clientId
	 * @param deviceId
	 * @return
	 * @throws Exception
	 */

	@GetMapping(value="/gps/track/location/report",produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> generateReport(HttpServletResponse response, @RequestParam("registration_id") long registrationId,
			@RequestHeader("channel") String channelId, @RequestHeader("uuid") String uuid,
			@RequestHeader("country") String country, @RequestHeader("Authorization") String authorization,
			@RequestHeader("client_id") String clientId, @RequestHeader("device_id") String deviceId) throws Exception {

		ByteArrayInputStream bis = trackerService.generateReport(registrationId);
		

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment");
		

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	

}

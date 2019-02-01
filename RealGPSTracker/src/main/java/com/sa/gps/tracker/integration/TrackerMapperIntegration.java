package com.sa.gps.tracker.integration;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sa.gps.tracker.model.GPSDataModel;
import com.sa.gps.tracker.model.LocationDataModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TrackerMapperIntegration {

	private static final String GEOCODING_URI = "https://maps.googleapis.com/maps/api/geocode/json";

	@Value("${google.api.key:lkhih889678iugkji7t889y9}")
	private String apiKey;

	
	
	/**
	 * This method will interact with Google Map API and will return GeoLocation
	 * 
	 * @param String latitude
	 * @param String longitude
	 * @return {@link LocationDataModel}
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws Exception 
	 */

	public LocationDataModel getGeoCodingForLoc(String latitude,String longitude) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(GEOCODING_URI)
				.queryParam("latlng", latitude + "," + longitude)
				.queryParam("key", apiKey);

		log.info("Calling geocoding api with: " + builder.toUriString());
		//LocationDataModel geoCoding = restTemplate.getForObject(builder.toUriString(), LocationDataModel.class);
		//create mock response
		ObjectMapper mapper = new ObjectMapper();
		LocationDataModel geoCoding = mapper.readValue(new File("response.json"), LocationDataModel.class);
		log.info(geoCoding.toString());

		return geoCoding;
	}

}

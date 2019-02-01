package com.sa.gps.tracker.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.sa.gps.tracker.model.GPSDataModel;


public class GpsTrackerStepExecution extends AbstractSpringConfigurationTest {

	private static final Logger logger = LoggerFactory.getLogger(GpsTrackerStepExecution.class);
	public GPSDataModel dataModel = new GPSDataModel();
	public ObjectMapper objectMapperObj = new ObjectMapper();
	private ResponseEntity<?> response = null;

	@Given("^app/browser post to  with below request:$")
	public void app_browser_post_to_with_below_request(String arg1) throws Exception {
		dataModel = objectMapperObj.readValue(arg1,GPSDataModel.class);
	}

	@When("^consumer calls \"([^\"]*)\" api$")
	public void consumer_calls_api(String arg1) throws Exception {
		String url = buildUrl(HOST, PORT, arg1);
		HttpEntity<?> requestEntity = new HttpEntity<>(dataModel, getDefaultHttpHeaders());
		response = invokeRESTCall(url, HttpMethod.POST, requestEntity); 
		
	}

	@Then("^consumer gets (\\d+) with below response$")
	public void consumer_gets_with_below_response(int arg1) throws Exception {
		if (response != null && response.getStatusCode().is2xxSuccessful()) {
			assertEquals(arg1, response.getStatusCode().value());
		}
		
	}

}

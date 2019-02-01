package com.sa.gps.tracker.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sa.gps.tracker.exception.TrackerException;
import com.sa.gps.tracker.model.GPSDataModel;
import com.sa.gps.tracker.model.LocationDataModel;
import com.sa.gps.tracker.repository.TrackerRepository;
import com.sa.gps.tracker.service.GPSTrackerService;

@RunWith(SpringRunner.class)
@WebMvcTest(GPSTrackerController.class)
public class GPSTrackerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GPSTrackerService trackerService;

	@MockBean
	private TrackerRepository trackerRepo;

	@Test
	public void getLocation_ShouldReturnLocation() throws Exception {
		given(trackerService.getDataLocation(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString()))
				.willReturn(new LocationDataModel());
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/gps/track/location?latitude=58.29&longitude=-78.67&registration_id=105341013554399291")
				.header("Authorization", "98y89ygi").header("country", "MX").header("device_id", "989y8ug87t87t8g")
				.header("channel", "Mobile").header("uuid", "0989yug87t87guigv8u")
				.header("client_id", "knkiugh87t98t8")).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void getLocation_ShouldReturnNotFound() throws Exception {
		given(trackerService.getDataLocation(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString()))
				.willThrow(new TrackerException("Vehicle Not Registered in Portal"));
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/v1/gps/track/location?latitude=58.29&longitude=-78.67&registration_id=105341013554399291")
				.header("Authorization", "98y89ygi").header("country", "MX").header("device_id", "989y8ug87t87t8g")
				.header("channel", "Mobile").header("uuid", "0989yug87t87guigv8u")
				.header("client_id", "knkiugh87t98t8")).andExpect(status().isBadRequest()).andReturn();
	}
	
	@Test
	public void createLocation_ShouldRegistrationId() throws Exception {
		given(trackerService.createDataLocation(new GPSDataModel()))
				.willReturn(Mockito.anyLong());
		mockMvc.perform(MockMvcRequestBuilders
				.post("/api/v1/gps/track/location")
				.header("Authorization", "98y89ygi").header("country", "MX").header("device_id", "989y8ug87t87t8g")
				.header("channel", "Mobile").header("uuid", "0989yug87t87guigv8u")
				.header("client_id", "knkiugh87t98t8")
				.contentType("application/json")
				.content(" { \"latitude\": \"18.78\", \"longitude\": \"-67.89\" , \"licensePlate\": \"ANY-6789\" , \"vehicleBrand\": \"NISAN\" , \"vehicleType\": \"SUV\"}"))
				.andExpect(status().isCreated()).andReturn();
	}

	

}

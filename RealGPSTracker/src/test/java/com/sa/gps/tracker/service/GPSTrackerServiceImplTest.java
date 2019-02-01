package com.sa.gps.tracker.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sa.gps.tracker.entity.GPSDataEntity;
import com.sa.gps.tracker.integration.TrackerMapperIntegration;
import com.sa.gps.tracker.model.LocationDataModel;
import com.sa.gps.tracker.repository.TrackerRepository;
import com.sa.gps.tracker.service.impl.GPSTrackerServiceImpl;

@RunWith(SpringRunner.class)
public class GPSTrackerServiceImplTest {
	
	@MockBean
	private TrackerRepository trackerRepo;
	
	@MockBean
	TrackerMapperIntegration trackerMapperIntg;
	
	@MockBean
	private SimpMessagingTemplate webSocket;
	
	@InjectMocks
	private GPSTrackerServiceImpl service;
	
	List<GPSDataEntity> entity;
	
	@Before
	public void setUp(){
		GPSDataEntity entityObj = new GPSDataEntity();
		entityObj.setLatitude(Mockito.anyString());
		entityObj.setLongitude(Mockito.anyString());
		entity= new ArrayList<>();
		entity.add(entityObj);
	}
	
	@Test
	public void getDataLocationTest() throws Exception{
		given(trackerRepo.findByregId(Mockito.anyLong()))
		.willReturn(entity);
		given(trackerMapperIntg.getGeoCodingForLoc(Mockito.anyString(),Mockito.anyString()))
		.willReturn(new LocationDataModel());
		assertThat(service.getDataLocation(Mockito.anyLong(), Mockito.anyString(), Mockito.anyString()))
		.equals(new LocationDataModel());
	}
	
	

}

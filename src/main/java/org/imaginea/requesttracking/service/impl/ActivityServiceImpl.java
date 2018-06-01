package org.imaginea.requesttracking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.imaginea.requesttracking.dao.impl.ActivityDaoImpl;
import org.imaginea.requesttracking.entity.Activity;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDaoImpl activityDao;
	
	public void createActivity(ServiceRequest serviceRequest) {

/*		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();*/

		Activity activity = new Activity();
		activity.setServicerequest(serviceRequest);
		activity.setCreatedate("date");
/*		serviceRequest.getActivity().add(activity);*/


	}

}

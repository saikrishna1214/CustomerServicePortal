package org.imaginea.requesttracking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.imaginea.requesttracking.dao.impl.ActivityDaoImpl;
import org.imaginea.requesttracking.entity.Activities;
import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDaoImpl activityDao;
	
	public void createActivity(ServiceRequest serviceRequest) {

		Activities activity = new Activities();
		activity.setServicerequest(serviceRequest);
		activity.setUpdatedDescription(serviceRequest.getDescription());
		activity.setStatusUpdate(serviceRequest.getStatus());
		activity.setUpdateddate(java.time.LocalDate.now());
		serviceRequest.getActivity().add(activity);
		activityDao.createActivityDao(activity);
	}

}

package org.imaginea.requesttracking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imaginea.requesttracking.service.impl.ActivityServiceImpl;
import org.imaginea.requesttracking.service.impl.HomepageDetailsImpl;
import org.imaginea.requesttracking.service.impl.ServiceRequestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class ServiceRequest
 */
public class ServiceRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accountidvalue = request.getParameter("accountid");
		String contactidvalue = request.getParameter("contactid");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int accountid = Integer.parseInt(accountidvalue);
		int contactid = Integer.parseInt(contactidvalue);
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ServiceRequestImpl getservice = (ServiceRequestImpl) context.getBean("servicerequest");
		ActivityServiceImpl activityServiceImpl = (ActivityServiceImpl) context.getBean("activity");
		String employee_email = (String) request.getSession().getAttribute("email");
		org.imaginea.requesttracking.entity.ServiceRequest serviceRequest = getservice.createServiceRequest(accountid,
				contactid, title, description, employee_email);
		activityServiceImpl.createActivity(serviceRequest,employee_email);
		/*HomepageDetailsImpl gethomepage = (HomepageDetailsImpl) context.getBean("homepagedetails");
		gethomepage.setServiceRequests(employee, serviceRequest);*/
		response.sendRedirect("ViewServiceRequests");
	}

}

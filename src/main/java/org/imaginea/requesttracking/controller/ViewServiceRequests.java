package org.imaginea.requesttracking.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.imaginea.requesttracking.entity.ServiceRequest;
import org.imaginea.requesttracking.service.impl.ServiceRequestImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Servlet implementation class ViewServiceRequests
 */
public class ViewServiceRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
		ServiceRequestImpl getservice = (ServiceRequestImpl) context.getBean("servicerequest");
		Collection<ServiceRequest> servicerequests = getservice.getAllServiceRequests();
		request.getSession().setAttribute("servicerequests", servicerequests);
		response.sendRedirect("ViewServiceRequests.jsp");
	}

}
